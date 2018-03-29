package com.allSales.domain;

import java.util.Date;

import javax.persistence.*;
	
	@Entity(name = "persistentlogins")
	public class PersistentLogin {

		@Id
		private String series;

		private String username;
		private String token;

		@Column(name = "last_used", insertable = false, updatable = false)
		@Temporal(TemporalType.TIMESTAMP)
		private Date last_used;

		public String getSeries() {
			return series;
		}

		public void setSeries(String series) {
			this.series = series;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public Date getLast_used() {
			return last_used;
		}

		public void setLast_used(Date last_used) {
			this.last_used = last_used;
		}

	}


