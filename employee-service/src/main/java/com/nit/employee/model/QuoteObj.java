package com.nit.employee.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteObj {
	private List<Quote> quotes;
	private Long total;
	private Integer skip;
	private Integer limit;
}
