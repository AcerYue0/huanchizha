package game;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class Id{
	private int id;
	private URL path;
	URL[] paths = new URL[] {
	setGameView.class.getResource("/resources/Kedama.png"),
	setGameView.class.getResource("/resources/PointSmall.png"),
	setGameView.class.getResource("/resources/PointMidium.png"),
	setGameView.class.getResource("/resources/PointLarge.png"),
	setGameView.class.getResource("/resources/Wen.png"),
	setGameView.class.getResource("/resources/Sakuya.png"),
	setGameView.class.getResource("/resources/Marisa.png"),
	setGameView.class.getResource("/resources/Remilia.png"),
	setGameView.class.getResource("/resources/Reimu.png"),
	setGameView.class.getResource("/resources/Tenshi.png"),
	setGameView.class.getResource("/resources/Teyi.png"),
	setGameView.class.getResource("/resources/Chen.png"),
	setGameView.class.getResource("/resources/Yamaxanadu.png"),
	setGameView.class.getResource("/resources/Suwako.png"),
	setGameView.class.getResource("/resources/Ran.png"),
	setGameView.class.getResource("/resources/Youmu.png"),
	setGameView.class.getResource("/resources/Flandre.png"), 
	setGameView.class.getResource("/resources/Meirin.png"),
	setGameView.class.getResource("/resources/Komaji.png"), 
	setGameView.class.getResource("/resources/Kanako.png"), 
	setGameView.class.getResource("/resources/Alice.png"),
	setGameView.class.getResource("/resources/Inaba.png"),
	setGameView.class.getResource("/resources/Yuyuko.png"),
	setGameView.class.getResource("/resources/Sanae.png"), 
	setGameView.class.getResource("/resources/Murasaki.png"), 
	setGameView.class.getResource("/resources/Suika.png"), 
	setGameView.class.getResource("/resources/Keine.png"), 
	setGameView.class.getResource("/resources/Mokou.png"),
	setGameView.class.getResource("/resources/Yuugi.png"),
	setGameView.class.getResource("/resources/Ninngyou.png")
	};
	List<URL> pathStorage = Arrays.asList(paths);
	
	public Id(int id) {
		this.setId(id);
		this.setPath(paths[id]);
	}
	public Id(int id, URL path){
		this.id = id;
		this.path = path;
	}
	
	public URL getPath() {
		return path;
	}
	public void setPath(URL path) {
		this.path = path;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
