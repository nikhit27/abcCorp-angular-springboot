package com.cts.ExternalEntities.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="color")
@IdClass(ColorCompositeKey.class)
public class ColorEntity implements Serializable{

	@Id
	@Column(name= "color_id")
	private Integer colorId;

	@Id
	@Column(name= "model_id")
	private Integer modelId;
}
