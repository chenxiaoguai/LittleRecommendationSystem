
package common;

import java.util.ArrayList;


/**
 * @author zhengjun
 * @email zhengjunbase@gmail.com
 * 
 * 
 * 总记录数：
 * @Todo
 * 1: 分析每次购买之前的点击数 （按品牌，按用户）
 * 2: 分析每次购买的最早点击时间和最近点击时间 （按品牌，按用户） doing
 * 3：分析收藏和加入购物车的特点
 *
 */

public class RecordList {


	private ArrayList<Record> recordList;

	public ArrayList<Record> getAllrecord() {
		return recordList;
	}

	public void setAllrecord(ArrayList<Record> allrecord) {
		this.recordList = allrecord;
	}
	
	public void addRecordToAllRecord(Record record){
		if(this.recordList == null)
			this.recordList = new ArrayList<Record>();
		recordList.add(record);
	}
}
