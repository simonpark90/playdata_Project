package model.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@NamedQuery(name="selectedList",
			query="select w.content from word w where w.date between :startDate and :endDate")
@Table(name="word")
@Entity(name="word")
public class WordDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_word_gen")
	@SequenceGenerator(name="seq_word_gen",sequenceName="seq_word",allocationSize=1)
	private int num;
	
	@Column
	private String content;
	
	@Column(name="writedate")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Builder
	public WordDTO(String content, Date date) {
		this.content = content;
		this.date = date;
	}
	
}
