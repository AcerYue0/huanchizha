package huanchizha;

import java.util.Arrays;
import java.util.List;

public class Id{
	private int id;
	private CardId name;
	private CardPath path;
	Integer[] ids = new Integer[] {
			0, 1, 3, 6, 
			1200, 1201, 1300, 1301, 1500, 1501, 
			200, 201, 202, 203, 
			300, 301, 302, 303, 
			400, 401, 402, 403, 404, 
			500, 501, 502, 503, 504, 
			600, 
			10402
	};
	List<Integer> idStorage = Arrays.asList(ids);
	List<CardId> cardList = Arrays.asList(CardId.values());
	List<CardPath> cardPathList = Arrays.asList(CardPath.values());
	public Id(int id) {
		this.setId(id);
		this.name = (CardId) cardList.get(idStorage.indexOf(id));
		this.path = (CardPath) cardPathList.get(idStorage.indexOf(id));
	}
	public Id(int id, CardId name, CardPath path){
		this.setId(id);
		this.name = name;
		this.path = path;
	}
	@Override
	public String toString() {
		return String.valueOf(name);
	}
	public static int getCardId(CardId name) {
		switch(name) {
			case Kedama:
				return 0;
			case PointSmall:
				return 1;
			case PointMidium:
				return 3;
			case PointLarge:
				return 6;
			case Wen:
				return 1200;
			case Sakuya:
				return 1201;
			case Marisa:
				return 1300;
			case Remilia:
				return 1301;
			case Reimu:
				return 1500;
			case Tenshi:
				return 1501;
			case Teyi:
				return 200;
			case Chen:
				return 201;
			case Yamaxanadu:
				return 202;
			case Suwako:
				return 203;
			case Ran:
				return 300;
			case Youmu:
				return 301;
			case Flandre:
				return 302;
			case Meirin:
				return 303;
			case Komaji:
				return 400;
			case Kanako:
				return 401;
			case Alice:
				return 402;
			case Ninngyou:
				return 10402;
			case Inaba:
				return 403;
			case Yuyuko:
				return 404;
			case Sanae:
				return 500;
			case Murasaki:
				return 501;
			case Suika:
				return 502;
			case Keine:
				return 503;
			case Mokou:
				return 504;
			case Yuugi:
				return 600;
			default:
				throw new Error("No such card at id " + name);
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
