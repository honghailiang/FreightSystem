package com.mango.jtt.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mango.jtt.box.JAutoCompleteComboBox;
import com.mango.jtt.container.AirContainer;
import com.mango.jtt.model.AirFreight;
import com.mango.jtt.service.AirFreightService;
import com.mango.jtt.util.FormatUtil;
import com.mango.jtt.util.StringUtil;

/**
 * @author HHL
 * @data 2016年8月14日 运费计算系统
 * 
 */
public class FreightSwing extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GridBagLayout g = new GridBagLayout();
	GridBagConstraints c = new GridBagConstraints();

	public FreightSwing(String str) {
		super(str);
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(g);
		// 调用方法
		addComponent();
		submit.addActionListener(this);
		setVisible(true);
		setLocationRelativeTo(null);// 设居中显示;
	}

	// 在这个方法中将会添加所有的组件;使用的网格组布局
	public void addComponent() {
		// 相关信息输入
		noteInformation = new JLabel("请输入相关信息");
		// 指定组件边框周围的外部填充。默认为不填充。
		c.insets = new Insets(2, 1, 1, 1);
		add(g, c, noteInformation, 0, 0, 1, 1);
		// 始发站
		originStation = new JLabel("始发站：");
		add(g, c, originStation, 0, 1, 1, 1);
		// 始发站名称
		originStationName = new JLabel("天津");
		add(g, c, originStationName, 1, 1, 1, 1);
		// 目的地
		destinationStation = new JLabel("目的地：");
		add(g, c, destinationStation, 0, 2, 1, 1);
		// 复选框及其内容 城市和省份
		cityProvince = new JAutoCompleteComboBox(new DefaultComboBoxModel(
				getCityProvince()));
		add(g, c, cityProvince, 1, 2, 1, 1);
		// province = new JAutoCompleteComboBox(this, new DefaultComboBoxModel(
		// getProvince()), new ItemListener() {
		//
		// @Override
		// public void itemStateChanged(ItemEvent e) {
		// itemChange();
		// }
		//
		// });
		// add(g, c, province, 1, 2, 1, 1);
		//
		// // 复选框及内容 城市
		// city = new JAutoCompleteComboBox(new
		// DefaultComboBoxModel(getCity()));
		// add(g, c, city, 2, 2, 1, 1);
		//
		// province.addItemListener(new ItemListener() {
		//
		// @Override
		// public void itemStateChanged(ItemEvent e) {
		// itemChange();
		// }
		//
		// });

		// 卷烟数量（万支）：
		quantity = new JLabel("卷烟数量(万支)：");
		add(g, c, quantity, 0, 3, 1, 1);
		// 数量输入框
		textQuantity = new JTextField(15);
		add(g, c, textQuantity, 1, 3, 1, 1);
		// 配送方式
		deliveryMethod = new JLabel("配送方式：");
		add(g, c, deliveryMethod, 0, 4, 1, 1);
		// 派送 单选框
		send = new JRadioButton("派送");
		add(g, c, send, 1, 4, 1, 1);
		// 自提 单选框
		take = new JRadioButton("自提");
		add(g, c, take, 2, 4, 1, 1);
		ButtonGroup group = new ButtonGroup();
		group.add(send);
		group.add(take);
		// submit按钮
		submit = new JButton("submit");
		c.insets = new Insets(7, 0, 4, 0);
		add(g, c, submit, 1, 5, 1, 1);

		result = new JTextArea(15, 30);
		add(g, c, result, 0, 6, 3, 4);

	}

	private Object[] getCityProvince() {
		Object[] PRO1 = AirContainer.cityProvinceList.toArray();
		Object[] PRO2 = { "请选择目的地" };
		Object[] PRO = arrayProcess(PRO1, PRO2);
		return PRO;
	}

	/**
	 * @return 获取省份
	 */
	private Object[] getProvince() {
		Object[] PRO1 = AirContainer.airCitySelectorMap.keySet().toArray();
		Object[] PRO2 = { "请选择省份" };
		Object[] PRO = arrayProcess(PRO1, PRO2);
		return PRO;
	}

	/**
	 * @return 根据省份获取城市
	 */
	private Object[] getCity() {
		String key = (String) province.getSelectedItem();
		List<String> cityList = AirContainer.airCitySelectorMap.get(key);
		Object[] city1 = { "请选择城市" };
		Object[] city2;
		if (null != cityList) {
			Object[] cityArray = cityList.toArray();
			city2 = arrayProcess(cityArray, city1);
		} else {
			city2 = city1;
		}
		return city2;
	}

	/**
	 * 根据所选省份，显示城市
	 */
	public void itemChange() {
		Object[] city2 = getCity();
		city.setModel(new DefaultComboBoxModel(city2));

	}

	/**
	 * @param PRO
	 * @param PRO2
	 * @return 数组处理, 按照汉字进行排序并合并数组
	 */
	private Object[] arrayProcess(Object[] PRO, Object[] PRO2) {
		Comparator<Object> com = Collator.getInstance(java.util.Locale.CHINA);
		Arrays.sort(PRO, com);
		int strl1 = PRO2.length;
		int strl2 = PRO.length;
		PRO2 = Arrays.copyOf(PRO2, strl1 + strl2);
		System.arraycopy(PRO, 0, PRO2, strl1, strl2);
		return PRO2;
	}

	public void add(GridBagLayout g, GridBagConstraints c, JComponent jc,
			int x, int y, int gw, int gh) {
		// 指定单元格起始行和列，x为列，y为行，默认值为0
		c.gridx = x;
		c.gridy = y;
		// 表示组件在单元格内的对齐方式
		c.anchor = GridBagConstraints.WEST;
		// 指定单元格行和列的范围。默认值为1，w为列，h为行
		c.gridwidth = gw;
		c.gridheight = gh;
		g.setConstraints(jc, c);
		add(jc);
	}

	JLabel noteInformation, originStation, quantity;
	JLabel deliveryMethod, destinationStation;
	JLabel originStationName;
	JTextField textQuantity;
	JRadioButton send, take;
	JComboBox province, city, cityProvince;
	JButton submit;
	JTextArea result;

	@Override
	public void actionPerformed(ActionEvent arg0) {

		String osn = originStationName.getText();
		String pro = (String) cityProvince.getSelectedItem();
		if (StringUtil.isEmpty(pro) || "请选择目的地".equals(pro)) {
			toolTip("请选择目的地！");
			cityProvince.grabFocus();
			return;
		}
		if (!AirContainer.cityProvinceList.contains(pro)) {
			toolTip("目的地 " + pro + " 不存在，请选择正确的目的地！");
			cityProvince.grabFocus();
			return;
		}
		// String cit = (String) city.getSelectedItem();
		// if (StringUtil.isEmpty(cit) || "请选择城市"equals(cit)) {
		// toolTip("请选择城市！");
		// city.grabFocus();
		// return;
		// }
		String quan = textQuantity.getText();
		if (StringUtil.isEmpty(quan) || !StringUtil.isNumeric(quan)) {
			toolTip("请填写正确的卷烟数量！");
			textQuantity.grabFocus();
			return;
		}
		String sen = send.getText();
		String tak = take.getText();
		if (!take.isSelected() && !send.isSelected()) {
			toolTip("请选择配送方式！");
			return;
		}

		// 配送方式
		String takeType = (String) (send.isSelected() ? sen : tak);
		// 空运运费总数
		AirFreight af = AirFreightService.computeFreight(osn + "-" + pro,
				takeType, quan);

		String num = "始发站：" + osn + "\n目的站：" + pro + "\n卷烟数量(万支)：" + quan
				+ "\n配送方式：" + takeType + "\n航空运费合计(元)："
				+ FormatUtil.formatDoubleT(af.getAirTotalCost())
				+ "\n公路运费合计(元)："
				+ FormatUtil.formatDoubleT(af.getLandTotalCost())
				+ "\n航空运费 - 公路运费(元)："
				+ FormatUtil.formatDoubleT(af.getMarginCost());
		result.setText(num);
	}

	/**
	 * @param mes
	 *            提示框
	 */
	private void toolTip(String mes) {
		Toolkit.getDefaultToolkit().beep();
		JOptionPane.showMessageDialog(null, mes, "温馨提示",
				JOptionPane.INFORMATION_MESSAGE);
		return;
	}

}
