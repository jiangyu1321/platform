package com.jhon.yu.code.generator.platform.core.coder.tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 此类用来将mysql的表直接生成JavaBean
 * @author
 *
 */
public class DBFiledsToJavaBean extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JCheckBox checkBox;
	Properties p = new Properties();
	String configFile = "config.ini";
	String sqlStr = "city.sql";
	private JLabel lblNewLabel_4;

	public DBFiledsToJavaBean() {

		setResizable(false);

		setTitle("MySQL生成javabean小工具");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		setBounds(100, 100, 484, 324);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		txtLocalhost = new JTextField();
		txtLocalhost.setText("localhost");
		txtLocalhost.setBounds(146, 10, 147, 21);
		panel.add(txtLocalhost);
		txtLocalhost.setColumns(10);

		JLabel lblIp = new JLabel("IP:");
		lblIp.setBounds(80, 13, 30, 15);
		panel.add(lblIp);

		JLabel label = new JLabel("数据库:");
		label.setBounds(80, 42, 54, 15);
		panel.add(label);

		textField = new JTextField();
		textField.setBounds(146, 39, 147, 21);
		panel.add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("表名:");
		label_1.setBounds(80, 127, 54, 15);
		panel.add(label_1);

		textField_1 = new JTextField();
		textField_1.setBounds(146, 124, 147, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel label_2 = new JLabel("包名:");
		label_2.setBounds(79, 156, 54, 15);
		panel.add(label_2);

		txtComyourcom = new JTextField();
		txtComyourcom.setText("com.jifenn.operateCenter.entity");
		txtComyourcom.setBounds(146, 155, 147, 21);
		panel.add(txtComyourcom);
		txtComyourcom.setColumns(10);

		JLabel lblNewLabel = new JLabel("输出目录：");
		lblNewLabel.setBounds(80, 190, 65, 15);
		panel.add(lblNewLabel);

		textField_3 = new JTextField();
		textField_3.setBounds(146, 186, 147, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);

		checkBox = new JCheckBox("生成包结构目录");
		checkBox.setSelected(true);
		checkBox.setBounds(145, 213, 147, 23);
		panel.add(checkBox);

		JLabel lblNewLabel_1 = new JLabel("可以指定表名，也可以不指定");
		lblNewLabel_1.setBounds(303, 127, 176, 15);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("* 数据库名");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(303, 42, 66, 15);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("* 包结构");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(303, 158, 79, 15);
		panel.add(lblNewLabel_3);

		JButton button = new JButton("执行");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				go();
			}
		});
		button.setBounds(145, 242, 93, 23);
		panel.add(button);

		textField_4 = new JTextField();
		textField_4.setText("root");
		textField_4.setBounds(145, 93, 147, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);

		txtRoot = new JTextField();
		txtRoot.setText("root");
		txtRoot.setBounds(145, 66, 148, 21);
		panel.add(txtRoot);
		txtRoot.setColumns(10);

		JLabel label_3 = new JLabel("用户名:");
		label_3.setBounds(80, 69, 54, 15);
		panel.add(label_3);

		JLabel label_4 = new JLabel("密码:");
		label_4.setBounds(80, 96, 54, 15);
		panel.add(label_4);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(248, 242, 204, 23);
		panel.add(lblNewLabel_4);

		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				export();
				System.exit(0);
			}

		});

		inport();
	}

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private JTextField txtLocalhost;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtComyourcom;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txtRoot;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {

			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBFiledsToJavaBean frame = new DBFiledsToJavaBean();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void inport() {
		File config = new File(configFile);
		if (config.exists()) {
			try {
				InputStream is = new FileInputStream(config);
				p.load(is);
				is.close();
				setUIVal();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				config.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void setUIVal() {
		txtLocalhost.setText(p.getProperty("host", "localhost"));
		textField.setText(p.getProperty("database", ""));
		txtRoot.setText(p.getProperty("user", "root"));
		textField_4.setText(p.getProperty("pass", "1234"));
		txtComyourcom.setText(p.getProperty("packname", "com.jifenn.heartbeat.global.dao.domain"));
		textField_3.setText(p.getProperty("dirstr", ""));
		textField_1.setText(p.getProperty("tablename", ""));
	}

	private void export() {
		String host = txtLocalhost.getText();
		String database = textField.getText();
		String user = txtRoot.getText();
		String pass = textField_4.getText();
		String packname = txtComyourcom.getText();
		String dirstr = textField_3.getText();// 空表示当前目录
		String tablename = textField_1.getText();

		p.setProperty("host", host);
		p.setProperty("database", database);
		p.setProperty("user", user);
		p.setProperty("pass", pass);
		p.setProperty("packname", packname);
		p.setProperty("dirstr", dirstr);
		p.setProperty("tablename", tablename);

		try {
			OutputStream out = new FileOutputStream(configFile);
			p.store(out, "退出保存文件," + sdf.format(new Date()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setTips(String msg) {
		lblNewLabel_4.setText(msg);
	}

	public void go() {
		String host = txtLocalhost.getText();
		String database = textField.getText();

		if (database.length() == 0) {
			setTips("数据库名必填");
			return;
		}

		String user = txtRoot.getText();
		String pass = textField_4.getText();
		String packname = txtComyourcom.getText();
		String dirstr = textField_3.getText();// 空表示当前目录
		String tablename = textField_1.getText();
		boolean createPackage = checkBox.getSelectedObjects() != null;
		System.out.println(createPackage);
		if (dirstr != null && !dirstr.isEmpty()) {
			if (!dirstr.endsWith("/")) {
				dirstr += "/";
			}
		}
		File dir = new File(dirstr);
		if (createPackage) {
			dir = new File(dirstr + packname.replaceAll("\\.", "/"));
			if (!dir.exists()) {
				dir.mkdirs();
			}
		}
		String outputdir = dir.getAbsolutePath();// bean的生成目录

		Connection conn = null;
		try {

			conn = DBHandler.mysql(host, database, user, pass);
			if (tablename.length() > 0) {
				parseTableByShowCreate(conn, tablename, packname, outputdir);
			} else {
				parseAllTable(conn, packname, outputdir);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			setTips("找不到MySQL的jar包");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 开始处理生成所有表 如果不传入表名，表示将数据库中所有表生成bean; 可以指定表名生成bean;
	 */
	public void parseAllTable(Connection conn, String packname, String outputdir) {

		String sql = "show tables";
		ResultSet rs = DBHandler.query(conn, sql);
		try {
			while (rs.next()) {
				String tablename = rs.getString(1);
				parseTableByShowCreate(conn, tablename, packname, outputdir);
			}
			DBHandler.close(conn, null, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过 mysql逆向生成Bean;
	 * 
	 * @param conn
	 * @param tname
	 * @param outputdir
	 * @param packname
	 */
	private void parseTableByShowCreate(Connection conn, String tablename,String packname, String outputdir) {
		StringBuilder classInfo = new StringBuilder();
		classInfo.append("\r\n")
		.append("import javax.persistence.Column;").append("\r\n")
		.append("import javax.persistence.Entity;").append("\r\n")
		.append("import javax.persistence.FetchType;").append("\r\n")
		.append("import javax.persistence.Id;").append("\r\n")
		.append("import javax.persistence.JoinColumn;").append("\r\n")
		.append("import javax.persistence.ManyToOne;").append("\r\n")
		.append("import javax.persistence.Table;").append("\r\n")
		.append("import javax.persistence.GeneratedValue;").append("\r\n")
		.append("import static javax.persistence.GenerationType.IDENTITY;").append("\r\n")
		.append("\r\n")
		.append("import java.math.BigDecimal;").append("\r\n")
		.append("import java.util.Date;").append("\r\n")
		.append("\r\n");
		classInfo.append("/**\r\n *");
		
		boolean shouldCloseConn = false;

		String sql = "show create table " + tablename;
		ResultSet rs = null;
		try {
			rs = DBHandler.query(conn, sql);
			StringBuilder fields = new StringBuilder();
			StringBuilder methods = new StringBuilder();

			while (rs.next()) {
				String sqlstr = rs.getString(2);
				String lines[] = sqlstr.split("\r\n");
				for (int i = 0; i < lines.length; i++) {
					String line = lines[i];
					System.out.println(line);
					// System.out.println("------------");
					String regex = "\\s*`([^`]*)`\\s*(\\w+[^ ]*)\\s*(NOT\\s+NULL\\s*)?(AUTO_INCREMENT\\s*)?(DEFAULT\\s*([^ ]*|NULL|'0'|''|CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP)\\s*)?(COMMENT\\s*'([^']*)')?\\s*,\\s*";
					Pattern p = Pattern.compile(regex);
					Matcher m = p.matcher(line);
					while (m.find()) {
						String field = m.group(1);
						String type = typeTrans(m.group(2));
						String cmt = m.group(8);
						fields.append(getFieldStr(field, type, cmt));
						methods.append(getMethodStr(field, type));
					}
					if (i == lines.length - 1) {
						classInfo.append(" @Description ");
						int index = line.indexOf("COMMENT=");
						if (index != -1) {
							String tmp = line.substring(index + 8,line.length()-2);
							classInfo.append(tmp.replace("'", "")).append("实体");
						}
						classInfo.append("\r\n");
						classInfo.append(" * @className ").append(db2BeanTransform(tablename,true)).append("\r\n");
						classInfo.append(" * @userName jiangyu \r\n");
						classInfo.append(" * @date: ");
						classInfo.append(sdf.format(new Date()));
						classInfo.append("\r\n */\r\n\r\n");
						
					}
				}

			}
			classInfo.append("@Entity").append("\r\n").append("@Table(name = \"").append(tablename).append("\")").append("\r\n");
			classInfo.append("public class ").append(db2BeanTransform(tablename,true)/*.replace("City", "")*/).append(" implements java.io.Serializable").append("{\r\n");
			classInfo.append("\tprivate static final long serialVersionUID = 1L;").append("\r\n");
			classInfo.append(fields);
			classInfo.append(generateConstructor(db2BeanTransform(tablename,true)/*.replace("City", "")*/));
			classInfo.append(methods);
			classInfo.append("\r\n");
			classInfo.append("}");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//释放链接
			DBHandler.close(shouldCloseConn ? conn : null, null, rs);
		}

		String packageinfo = "package " + packname + ";\r\n\r\n";
		File file = new File(outputdir, db2BeanTransform(tablename,true) + ".java");
		System.out.println(file.getAbsolutePath());
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(packageinfo);
			fw.write(classInfo.toString());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 创建无参数的构造函数
	 * @param replace
	 * @return
	 */
	private Object generateConstructor(String entityName) {
		StringBuffer construct = new StringBuffer();
		construct.append("\r\n");
		construct.append("\t").append("public ").append(entityName).append("()").append("{\r\n").append("\t\t\r\n").append("\t}\r\n");
		construct.append("\r\n");
		return construct;
	}

	/**
	 * 
	 * @param type
	 * @return
	 */
	private String getMethodStr(String field, String type) {
		StringBuffer getPrefix = new StringBuffer();
		if("id".equals(field)){
			getPrefix.append("\t").append("@Id").append("\r\n")
			.append("\t").append("@GeneratedValue(strategy = IDENTITY)").append("\r\n")
			.append("\t").append("@Column(name = \"id\", unique = true, nullable = false)").append("\r\n");
		}else{
			getPrefix.append("\t@Column(name = \"").append(field).append("\")").append("\r\n");
		}
		StringBuilder get = new StringBuilder(getPrefix).append("\tpublic ");
		get.append(type).append(" ");
//		if (type.equals("boolean")) {
//			get.append(field);
//		} else {
//		}
		get.append("get");
		get.append(db2BeanTransform(field,true));
		get.append("(){").append("\r\n\t\treturn this.").append(db2BeanTransform(field,false))
				.append(";\r\n\t}\r\n");
		StringBuilder set = new StringBuilder("\tpublic void ");

//		if (type.equals("boolean")) {
//			set.append("is");
//			set.append(db2BeanTransform(field,true));
//		} else {
//		}
		set.append("set");
		set.append(db2BeanTransform(field,true));
		set.append("(").append(type).append(" ").append(db2BeanTransform(field,false))
				.append("){\r\n\t\tthis.").append(db2BeanTransform(field,false)).append(" = ")
				.append(db2BeanTransform(field,false)).append(";\r\n\t}\r\n");
		get.append(set);
		return get.toString();
	}

	public String upperFirestChar(String src) {
		return src.substring(0, 1).toUpperCase().concat(src.substring(1));
	}
	/**
	 * 属性字段和注释
	 * @param field
	 * @param type
	 * @param cmt
	 * @return
	 */
	private String getFieldStr(String field, String type, String cmt) {
		StringBuilder sb = new StringBuilder();
		sb.append("\t").append("/**").append("\r\n").append("\t").append(" * "+cmt).append("\r\n").append("\t").append(" */").append("\r\n");
		sb.append("\t").append("private ").append(type).append(" ")
				.append(db2BeanTransform(field,false)).append(";");
		sb.append("\r\n").append("\r\n");
		return sb.toString();
	}

	/**
	 * mysql的类型转换到java
	 * 
	 */
	public String typeTrans(String type) {
		if (type.contains("tinyint")) {
			return "Integer";
		} else if(type.contains("bigint")){
			return "Long";
		}else if (type.contains("int")||type.contains("unsigned")) {
			return "Integer";
		} else if(type.contains("timestamp")||type.contains("datetime")|| type.contains("date")){
			return "Date";
		} else if(type.contains("decimal")){
			return "BigDecimal";
		}else if (type.contains("varchar")|| type.contains("longtext")
				|| type.contains("time")
				|| type.contains("enum") || type.contains("set") || type.contains("text")) {
			return "String";
		} else if (type.contains("binary") || type.contains("blob")) {
			return "byte[]";
		} else {
			return "String";
		}
	}
	
	public static String db2BeanTransform(String str,boolean flag){
		while(str.contains("_")){
			int i = str.indexOf("_");
			if(i+1<str.length()){
				char c = str.charAt(i+1);
				String temp = (c+"").toUpperCase();
				str = str.replace("_"+c, temp);
			}
		}
		if(flag){
			str = str.substring(0,1).toUpperCase().concat(str.substring(1));
		}
		return str;
	}
}
