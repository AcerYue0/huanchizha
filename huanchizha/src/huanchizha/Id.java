package huanchizha;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class Id{
	private int id;
	private URL path;
	URL[] paths = new URL[] {
	Main.class.getResource("/resources/Kedama.png"),
	Main.class.getResource("/resources/PointSmall.png"),
	Main.class.getResource("/resources/PointMidium.png"),
	Main.class.getResource("/resources/PointLarge.png"),
	Main.class.getResource("/resources/Wen.png"),
	Main.class.getResource("/resources/Sakuya.png"),
	Main.class.getResource("/resources/Marisa.png"),
	Main.class.getResource("/resources/Remilia.png"),
	Main.class.getResource("/resources/Reimu.png"),
	Main.class.getResource("/resources/Tenshi.png"),
	Main.class.getResource("/resources/Teyi.png"),
	Main.class.getResource("/resources/Chen.png"),
	Main.class.getResource("/resources/Yamaxanadu.png"),
	Main.class.getResource("/resources/Suwako.png"),
	Main.class.getResource("/resources/Ran.png"),
	Main.class.getResource("/resources/Youmu.png"),
	Main.class.getResource("/resources/Flandre.png"), 
	Main.class.getResource("/resources/Meirin.png"),
	Main.class.getResource("/resources/Komaji.png"), 
	Main.class.getResource("/resources/Kanako.png"), 
	Main.class.getResource("/resources/Alice.png"),
	Main.class.getResource("/resources/Inaba.png"),
	Main.class.getResource("/resources/Yuyuko.png"),
	Main.class.getResource("/resources/Sanae.png"), 
	Main.class.getResource("/resources/Murasaki.png"), 
	Main.class.getResource("/resources/Suika.png"), 
	Main.class.getResource("/resources/Keine.png"), 
	Main.class.getResource("/resources/Mokou.png"),
	Main.class.getResource("/resources/Yuugi.png"),
	Main.class.getResource("/resources/Ninngyou.png")
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
