package repon;

import entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account,Integer> {
    @Override
    Optional<Account> findById(Integer integer);

    List<Account> findByName(String names);
    List<Account>findAll();
    List<Account> findByNameAndEmail(String name,String mail);
}
