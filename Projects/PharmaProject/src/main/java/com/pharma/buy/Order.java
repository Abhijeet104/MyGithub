package com.pharma.buy;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Order {
	@JsonProperty("customer")
	String customer;

	@JsonProperty("phone")
	String phone;

//	@JsonProperty("items")
//	@JsonDeserialize(contentUsing = SkipWrapperObjectDeserializer.class)
//    @SkipWrapperObject("item")
	
	@JsonProperty("items")
	List<Item> items;
	
	@JsonProperty("totalCost")
	double totalCost;
	
	
	
	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

/*
	public class SkipWrapperObjectDeserializer extends JsonDeserializer implements ContextualDeserializer {
		private Class wrappedType;
		private String wrapperKey;

		public JsonDeserializer createContextual(DeserializationContext ctxt, BeanProperty property)
				throws JsonMappingException {
			SkipWrapperObject skipWrapperObject = property.getAnnotation(SkipWrapperObject.class);
			wrapperKey = skipWrapperObject.value();
			JavaType collectionType = property.getType();
			JavaType collectedType = collectionType.containedType(0);
			wrappedType = collectedType.getRawClass();
			return this;
		}

		@Override
		public Object deserialize(JsonParser parser, DeserializationContext ctxt)
				throws IOException, JsonProcessingException {
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode objectNode = mapper.readTree(parser);
			JsonNode wrapped = objectNode.get(wrapperKey);
			Object mapped = mapIntoObject(wrapped);
			return mapped;
		}

		private Object mapIntoObject(JsonNode node) throws IOException, JsonProcessingException {
			JsonParser parser = node.traverse();
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(parser, wrappedType);
		}
	}

	@Retention(RetentionPolicy.RUNTIME)
	@JacksonAnnotation
	public @interface SkipWrapperObject {
	    String value();
	}
*/
}
