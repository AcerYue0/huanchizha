package huanchizha;

import java.net.URL;

public enum CardPath {
	Kedama(Main.class.getResource("/resources/Kedama.png")),
	PointSmall(Main.class.getResource("/resources/PointSmall.png")),
	PointMidium(Main.class.getResource("/resources/PointmMidium.png")),
	PointLarge(Main.class.getResource("/resources/PointLarge.png")),
	Wen(Main.class.getResource("/resources/Wen.png")),
	Sakuya(Main.class.getResource("/resources/Sakuya.png")),
	Marisa(Main.class.getResource("/resources/Marisa.png")), 
	Remilia(Main.class.getResource("/resources/Remilia.png")),
	Reimu(Main.class.getResource("/resources/Reimu.png")),
	Tenshi(Main.class.getResource("/resources/Tenshi.png")),
	Teyi(Main.class.getResource("/resources/Teyi.png")),
	Chen(Main.class.getResource("/resources/Chen.png")),
	Yamaxanadu(Main.class.getResource("/resources/Yamaxanadu.png")),
	Suwako(Main.class.getResource("/resources/Suwako.png")),
	Ran(Main.class.getResource("/resources/Ran.png")),
	Youmu(Main.class.getResource("/resources/Youmu.png")),
	Flandre(Main.class.getResource("/resources/Flandre.png")), 
	Meirin(Main.class.getResource("/resources/Meirin.png")),
	Komaji(Main.class.getResource("/resources/Komaji.png")), 
	Kanako(Main.class.getResource("/resources/Kanako.png")), 
	Alice(Main.class.getResource("/resources/Alice.png")),
	Inaba(Main.class.getResource("/resources/Inaba.png")),
	Yuyuko(Main.class.getResource("/resources/Yuyuko.png")),
	Sanae(Main.class.getResource("/resources/Sanae.png")), 
	Murasaki(Main.class.getResource("/resources/Murasaki.png")), 
	Suika(Main.class.getResource("/resources/Suika.png")), 
	Keine(Main.class.getResource("/resources/Keine.png")), 
	Mokou(Main.class.getResource("/resources/Mokou.png")),
	Yuugi(Main.class.getResource("/resources/Yuugi.png")),
	Ninngyou(Main.class.getResource("/resources/Ninngyou.png"));
	public final URL path;
	private CardPath(URL filepath) {
		this.path = filepath;
	}
	public String toString() {
		return String.valueOf(path);
	};

}
