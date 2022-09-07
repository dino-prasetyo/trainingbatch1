/**
 * Copyright (C) 2012-2013, Markus Sprunck
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or
 * without modification, are permitted provided that the following
 * conditions are met:
 *
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * - Redistributions in binary form must reproduce the above
 *   copyright notice, this list of conditions and the following
 *   disclaimer in the documentation and/or other materials provided
 *   with the distribution.
 *
 * - The name of its contributor may be used to endorse or promote
 *   products derived from this software without specific prior
 *   written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
 * CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * 
 */

package mycompany;

import mycompany.dao.BaseJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Qualifier (value= "mainApp")
public class MainApp
{

	private static final String[] CONFIG_PATH = {"classpath*:service.xml","classpath*:repository.xml"};

	//@Autowired
	DummyClass myBean;

	@Autowired
	BaseJdbcDao baseJdbcDao;

	void sayHello() {
		System.out.println(myBean.run("Hello World - "));
	}

	public static void main(final String[] args) {
		final ApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_PATH);
		final MainApp mainApp = (MainApp) context.getBean("mainApp");
		//mainApp.myBean = new DummyClass();
		//mainApp.baseJdbcDao.createTable();
		do{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Masukan ID = ");
			String id = scanner.nextLine();
			if("quit".equals(id))
			{
				break;
			}
			System.out.print("Masukan nama = ");
			scanner = new Scanner(System.in);
			String nama = scanner.nextLine();
			mainApp.baseJdbcDao.insertRecord(id, nama);
			System.out.println();
		}while (true);
		System.out.println("Total : " + mainApp.baseJdbcDao.countRecord());
		mainApp.baseJdbcDao.select();
	}

}
