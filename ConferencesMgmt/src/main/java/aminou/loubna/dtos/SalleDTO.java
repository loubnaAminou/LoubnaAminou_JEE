package aminou.loubna.dtos;


import lombok.Data;


@Data
public class SalleDTO {
	public Long id;
	public String nom;
	SessionDTO sessionDTO;
}