package ma.elrhazi.votingservice.mapper.cdeMapper;

import ma.elrhazi.votingservice.dto.GameDTO;
import ma.elrhazi.votingservice.entities.Game;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class GameMapper {
   /* public CustomerDTO fromCustomerToDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO);
        return customerDTO;
    }

    public Customer fromDTOToCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        return customer;
    }
    */
    public GameDTO toDto(Game game){
        GameDTO gmDTO= new GameDTO();
        BeanUtils.copyProperties(game,gmDTO);

        return gmDTO;
    }


    public Game toEntity(GameDTO gameDTO){
        Game gm = new Game();
        BeanUtils.copyProperties(gameDTO,gm);
        return gm;
    }

}
