package dev.paie.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import dev.paie.entite.Grade;

@Repository
public class GradeServiceJdbcTemplate implements GradeService {
	
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource){
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade noveauGrade) {
		String sql = "INSERT INTO GRADE (Code, NbHeuresBase, TauxBase) VALUES (?, ?, ?)";
		this.jdbcTemplate.update(sql, noveauGrade.getCode(), noveauGrade.getNbHeuresBase(), noveauGrade.getTauxBase());

	}

	@Override
	public void mettreAJour(Grade grade) {
		String sql = "UPDATE GRADE SET NBHEURESBASE = ? , TAUXBASE = ? WHERE Code=? ";
		this.jdbcTemplate.update(sql, grade.getNbHeuresBase(), grade.getTauxBase(), grade.getCode());

	}

	@Override
	public List<Grade> lister() {
		String sql = "SELECT * FROM GRADE";
		return this.jdbcTemplate.query(sql, new GradeMapper());
	}

}
