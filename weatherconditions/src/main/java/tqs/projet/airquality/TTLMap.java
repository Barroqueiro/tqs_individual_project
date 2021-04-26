package tqs.projet.airquality;

import java.util.*;
import java.time.LocalDateTime;

public class TTLMap<T,V>{

	private Map<T,V> map;
	private Map<T,LocalDateTime> keyTime ;
	private int ttl;
	
	public TTLMap(int l){
		map = new HashMap<T,V>();
		keyTime = new HashMap<T,LocalDateTime>();
		ttl = l;
	}


	public int size() {
		return map.size();
	}


	public boolean isEmpty() {
		return map.isEmpty();
	}


	public V get(Object key) {
		if (keyTime.containsKey(key)) {
			if (LocalDateTime.now().isBefore(keyTime.get(key))) {
				return map.get(key);
			}else {
				keyTime.remove(key);
			}
		}
		return null;
	}


	@SuppressWarnings("unchecked")
	public V put(Object key, Object value) {
		map.put((T) key, (V) value);
		keyTime.put((T) key, LocalDateTime.now().plusSeconds(ttl));
		return (V) value;
	}


	@Override
	public String toString() {
		return "TTLMap [map=" + map + ", keyTime=" + keyTime + ", ttl=" + ttl + "]";
	}
	
}
