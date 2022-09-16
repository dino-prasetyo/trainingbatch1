package id.co.klaten.security.dao;

import id.co.klaten.security.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity>
{
    UserEntity getByUserName(String userName);
}
