package ma.enset.backend.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private List<String> accountIds = new ArrayList<>();
}
