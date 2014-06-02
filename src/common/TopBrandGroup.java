package common;

import javax.naming.InitialContext;

public class TopBrandGroup extends ItemGroup{

	int minBrandSaleVolume;
	public static final TopBrandGroup singleton = new TopBrandGroup();
	
    private TopBrandGroup() {
    //	init();
	}
	
    public static TopBrandGroup getInstance(){
    	
    	return singleton;
    }
	public void init(){
		BrandList bl = ItemFactory.getTrainingBrands();
		for (Brand b : bl.getBrandMap().values()) {
			if(b.getSalesVolume() >= minBrandSaleVolume)
				put(b.getBrandId(),b);
		}
	}
	
	@Override
	public Brand get(int key){
		if(getItemsMap() == null || getItemsMap().size() == 0)
			init();
		 return (Brand) super.get(key);
	}
	
	public int getMinBrandSaleVolume() {
		return minBrandSaleVolume;
	}

	public void setMinBrandSaleVolume(int minBrandSaleVolume) {
		this.minBrandSaleVolume = minBrandSaleVolume;
		init();
	}
	
}
