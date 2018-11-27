package huanchizha;

public enum CardId {
	Kedama(0),
	PointSmall(1),
	PointMidium(3),
	PointLarge(6),
	Wen(1200),
	Sakuya(1201),
	Marisa(1300), 
	Remilia(1301),
	Reimu(1500),
	Tenshi(1501),
	Teyi(200),
	Chen(201),
	Yamaxanadu(202),
	Suwako(203),
	Ran(300),
	Youmu(301),
	Flandre(302), 
	Meirin(303),
	Komaji(400), 
	Kanako(401), 
	Alice(402),
	Inaba(403),
	Yuyuko(404),
	Sanae(500), 
	Murasaki(501), 
	Suika(502), 
	Keine(503), 
	Mokou(504),
	Yuugi(600),
	Ninngyou(10402);
	public final int id;
	
	private CardId(int id) {
		this.id = id;
	}

	public String toString() {
		return String.valueOf(id);
	};
}
