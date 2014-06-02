
package common;
import java.util.Arrays;
import java.util.LinkedHashMap;


/**
 * @author zhengjun
 * @email zhengjunbase@gmail.com
 * 
 * @Todo
 * 1: 分析每个用户所有查看的商品中有多少会购买
 * 2：分析每次用户查看商品的点击特点（包括点击次数，最早点击时间，最晚点击时间）
 * 3：分析用户购买过商品的点击特点（包括点击次数，最早点击时间，最晚点击时间）
 * 4：为用户聚类
 * 5：用户的总购买次数
 *
 */
public class UserList {

	private LinkedHashMap<Integer, User> userMap;

	
	public LinkedHashMap<Integer, User> getUserMap() {
		if(this.userMap == null)
			this.userMap = new LinkedHashMap<Integer, User>();

		return userMap;
	}
	public Item get(int key){
		return userMap.get(key);
	}
	public void setUserMap(LinkedHashMap<Integer, User> userMap) {
		this.userMap = userMap;
	}

	public void addToUserMap(User user ) {
		if(this.userMap == null)
			this.userMap = new LinkedHashMap<Integer, User>();
		
		userMap.put(user.getUserId(), user);
	}
	
	public void addRecordToAllUser( Record record){
		if(this.userMap == null)
			this.userMap = new LinkedHashMap<Integer, User>();

		if(!userMap.containsKey(record.getUserId())){
			User user = new User();
			user.setUserId(record.getUserId());
			addToUserMap(user);
		}
		
		userMap.get(record.getUserId()).addUserRecords(record);
			
	}

}
