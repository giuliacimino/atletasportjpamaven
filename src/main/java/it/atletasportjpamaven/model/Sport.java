package it.atletasportjpamaven.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "sport")
public class Sport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private Long id;
	@Column (name = "descrizione")
	private String descrizione;
	@Column (name = "datainizio")
	private LocalDate dataInizio;
	@Column (name = "datafine")
	private LocalDate dataFine;
	
	
	public Sport () {
		
	}
	
	public Sport (String descrizione, LocalDate dataInizio, LocalDate dataFine) {
		this.descrizione=descrizione;
		this.dataInizio=dataInizio;
		this.dataFine=dataFine;	
	}
	
	public Sport(String descrizione) {
		this.descrizione=descrizione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", descrizione=" + descrizione + ", dataInizio=" + dataInizio + ", dataFine="
				+ dataFine + "]";
	}
	
	

}
