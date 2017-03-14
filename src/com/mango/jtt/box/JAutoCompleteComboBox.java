package com.mango.jtt.box;

import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.mango.jtt.swing.FreightSwing;

/**
 * Aug 23, 2016
 * 
 * @author HHL 下拉列表输入自动填充类
 * 
 */
public class JAutoCompleteComboBox extends JComboBox {

	private AutoCompleter completer;

	public JAutoCompleteComboBox() {
		super();
		addCompleter();
	}

	public JAutoCompleteComboBox(ComboBoxModel cm) {
		super(cm);
		addCompleter();
	}

	public JAutoCompleteComboBox(FreightSwing fs, ComboBoxModel cm,
			ItemListener itemListener) {
		super(cm);
		addCompleter(fs, itemListener);
	}

	private void addCompleter(FreightSwing fs, ItemListener itemListener) {
		setEditable(true);
		completer = new AutoCompleter(this, itemListener, fs);

	}

	public JAutoCompleteComboBox(Object[] items) {
		super(items);
		addCompleter();
	}

	public JAutoCompleteComboBox(List v) {
		super((Vector) v);
		addCompleter();
	}

	private void addCompleter() {
		setEditable(true);
		completer = new AutoCompleter(this);
	}

	public void autoComplete(String str) {
		this.completer.autoComplete(str, str.length());
	}

	public String getText() {
		return ((JTextField) getEditor().getEditorComponent()).getText();
	}

	public void setText(String text) {
		((JTextField) getEditor().getEditorComponent()).setText(text);
	}

	public boolean containsItem(String itemString) {
		for (int i = 0; i < this.getModel().getSize(); i++) {
			String _item = " " + this.getModel().getElementAt(i);
			if (_item.equals(itemString))
				return true;
		}
		return false;
	}

	// public static void main(String[] args) {
	// JFrame frame = new JFrame();
	// Object[] items = new Object[] { "abc ", "aab ", "aba ", "hpp ", "pp ",
	// "hlp " };
	// DefaultComboBoxModel model = new DefaultComboBoxModel();
	// JComboBox cmb = new JAutoCompleteComboBox(model);
	// model.addElement("abc ");
	// model.addElement("aab ");
	// model.addElement("aba ");
	// model.addElement("hpp ");
	// model.addElement("pp ");
	// model.addElement("hlp ");
	// frame.getContentPane().add(cmb);
	// frame.setSize(400, 80);
	// frame.setVisible(true);
	// }
}