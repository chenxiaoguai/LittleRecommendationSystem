package common;

public class AddCartAction extends Action{
	
	public AddCartAction(Record r){
		super(r);
	}
	@Override
	public void addToActionChain(ActionChain chain) {
		chain.setAddCartAction(this);
		super.addToActionChain(chain);
	}

}
