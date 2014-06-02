package common;

import java.util.LinkedHashMap;



/**
 * @author zhengjun
 * @email  zhengjunbase@gmail.com
 * 
 * Todo
 * 1������������������
 * 2���������������������������������������������
 * 3: ������������������������������������������������������������������������������������������������������������������
 * 4��� ������������������������������������������������������������������������������������������������������������������������������
 * 5��� ���������������������������������������������������������������������������������������������������������������
 * 6: ���������������������������������������������������
 *
 */
public class BrandList {

	private LinkedHashMap<Integer, Brand> brandMap;



	/**
	 * @return the brandMap
	 */
	public Brand get(int key){
		return brandMap.get(key);
	}
	public LinkedHashMap<Integer, Brand> getBrandMap() {
		if(this.brandMap == null)
			this.brandMap = new LinkedHashMap<Integer, Brand>();
		return brandMap;
	}

	/**
	 * @param brandMap the brandMap to set
	 */
	public void setBrandMap(LinkedHashMap<Integer, Brand> brandMap) {
		this.brandMap = brandMap;
	}

	public void addToBrandMap(Brand brand) {
		if(this.brandMap == null)
			this.brandMap = new LinkedHashMap<Integer, Brand>();
		brandMap.put(brand.getBrandId(), brand);
	}
	
	public void addRecordToAllBrand(Record record){

		if(this.brandMap == null)
			this.brandMap = new LinkedHashMap<Integer, Brand>();

		if(!brandMap.containsKey(record.getBrandId())){
			Brand brand = new Brand();
			brand.setBrandId(record.getBrandId());
			addToBrandMap(brand);
		}
		brandMap.get(record.getBrandId()).addBrandRecords(record);
	}


}
