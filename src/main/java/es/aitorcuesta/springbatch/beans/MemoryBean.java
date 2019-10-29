package es.aitorcuesta.springbatch.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MemoryBean {

private List<InputDataBaseItem> items;
	
	public MemoryBean() {
		items = new ArrayList<>();
	}

	public List<InputDataBaseItem> getItems() {
		return items;
	}

	public void setItems(List<InputDataBaseItem> items) {
		this.items = items;
	}

	public synchronized InputDataBaseItem getNext() {
		return items.isEmpty() ? null : items.remove(0);
	}
	
	public int getElements() {
		return items.size();
	}
}
