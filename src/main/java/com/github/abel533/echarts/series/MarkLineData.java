package com.github.abel533.echarts.series;

import java.util.ArrayList;
import java.util.List;

import com.github.abel533.echarts.AbstractData;
import com.github.abel533.echarts.Label;
import com.github.abel533.echarts.style.LineStyle;

/**
 * 标线的数据数组。每个数组项可以是一个两个值的数组，分别表示线的起点和终点，每一项是一个对象，有下面几种方式指定起点或终点的位置。 通过 x, y 属性指定相对容器的屏幕坐标，单位像素，支持百分比。 用 coord 属性指定数据在相应坐标系上的坐标位置，单个维度支持设置 'min', 'max', 'average'。 直接用 type
 * 属性标注系列中的最大值，最小值。这时候可以使用 valueIndex 或者 valueDim 指定是在哪个维度上的最大值、最小值、平均值。 如果是笛卡尔坐标系的话，也可以通过只指定 xAxis 或者 yAxis 来实现 X 轴或者 Y 轴为某值的标线，见示例 scatter-weight 当多个属性同时存在时，优先级按上述的顺序。 也可以是直接通过
 * type 设置该标线的类型，是最大值的线还是平均线。同样的，这时候可以通过使用 valueIndex 指定维度。
 * 
 * @author vcdemon
 * @time 2016年9月6日 下午6:24:51
 */
public class MarkLineData extends AbstractData<MarkLineData> {
	private static final long serialVersionUID = -5455031518799621628L;

	private MarkLineData data0;
	private MarkLineData data1;

	/**
	 * 起点标记的图形。 ECharts 提供的标记类型包括 'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
	 */
	private String symbol;

	public String symbol() {
		return symbol;
	}

	public MarkLineData symbol(String symbol) {
		this.symbol = symbol;
		return this;
	}

	public MarkLineData data0() {
		return data0;
	}

	public MarkLineData data0(MarkLineData data0) {
		if (data0 == null) {
			data0 = new MarkLineData();
		}
		this.data0 = data0;
		return this;
	}

	public MarkLineData data1(MarkLineData data1) {
		if (data1 == null) {
			data1 = new MarkLineData();
		}
		this.data1 = data1;
		return this;
	}

	public MarkLineData data1() {
		return data1;
	}

	/**
	 * 该数据项线的样式，起点和终点项的 lineStyle会合并到一起。
	 */
	private LineStyle lineStyle;
	/**
	 * 该数据项标签的样式，起点和终点项的 label会合并到一起。
	 */
	private Label label;
	/**
	 * 特殊的标注类型，用于标注最大值最小值等。 可选: 'min' 最大值。 'max' 最大值。 'average' 平均值。
	 */
	private String type;
	/**
	 * 在使用 type 时有效，用于指定在哪个维度上指定最大值最小值，可以是 0（xAxis, radiusAxis），1（yAxis, angleAxis），默认使用第一个数值轴所在的维度。
	 */
	private Integer valueIndex;

	/**
	 * 在使用 type 时有效，用于指定在哪个维度上指定最大值最小值。这可以是维度的直接名称，例如折线图时可以是x、angle等、candlestick 图时可以是open、close等维度名称。
	 */
	private String valueDim;

	/**
	 * 起点或终点的坐标。坐标格式视系列的坐标系而定，可以是直角坐标系上的 x, y，也可以是极坐标系上的 radius, angle。 注：对于 axis.type 为 'category' 类型的轴 如果 coord 值为 number，则表示 axis.data 的 index。 如果 coord 值为 string，则表示 axis.data
	 * 中具体的值。注意使用这种方式时，xAxis.data 不能写成 [number, number, ...]，而只能写成 [string, string, ...]，否则不能被 markPoint / markLine 用『具体值』索引到。
	 */
	private List<Object> coord;

	/**
	 * 相对容器的屏幕 x 坐标，单位像素。
	 */
	private Double x;

	/**
	 * 相对容器的屏幕 y 坐标，单位像素。
	 */
	private Double y;

	/**
	 * 标注值，可以不设。
	 */
	private Double value;

	public Double value() {
		if (value == null) {
			return 0D;
		}
		return value;
	}

	public MarkLineData value(Double value) {
		this.value = value;
		return this;
	}

	public Double Y() {
		if (y == null) {
			y = 0D;
		}
		return y;
	}

	public MarkLineData Y(Double y) {
		this.y = y;
		return this;
	}

	public Double X() {
		if (x == null) {
			this.x = 0D;
		}
		return x;
	}

	public MarkLineData X(Double x) {
		this.x = x;
		return this;
	}

	public List<Object> coord() {
		if (this.coord == null) {
			this.coord = new ArrayList<>();
		}
		return coord;
	}

	public MarkLineData coord(List<Object> coord) {
		this.coord = coord;
		return this;
	}

	public String valueDim() {
		if (this.valueDim == null) {
			this.valueDim = new String();
		}
		return valueDim;
	}

	public MarkLineData valueDim(String valueDim) {
		this.valueDim = valueDim;
		return this;
	}

	public Integer valueIndex() {
		return valueIndex;
	}

	public MarkLineData valueIndex(Integer valueIndex) {
		this.valueIndex = valueIndex;
		return this;
	}

	public String type() {
		if (this.type == null) {
			this.type = new String();
		}
		return type;
	}

	public MarkLineData type(String type) {
		this.type = type;
		return this;
	}

	public Label label() {
		if (this.label == null) {
			this.label = new Label();
		}
		return this.label;
	}

	public MarkLineData label(Label label) {
		this.label = label;
		return this;
	}

	public LineStyle lineStyle() {
		if (this.lineStyle == null) {
			this.lineStyle = new LineStyle();
		}
		return lineStyle;
	}

	public MarkLineData lineStyle(LineStyle lineStyle) {
		this.lineStyle = lineStyle;
		return this;
	}

	public MarkLineData getData0() {
		return data0;
	}

	public void setData0(MarkLineData data0) {
		this.data0 = data0;
	}

	public MarkLineData getData1() {
		return data1;
	}

	public void setData1(MarkLineData data1) {
		this.data1 = data1;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public LineStyle getLineStyle() {
		return lineStyle;
	}

	public void setLineStyle(LineStyle lineStyle) {
		this.lineStyle = lineStyle;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getValueIndex() {
		return valueIndex;
	}

	public void setValueIndex(Integer valueIndex) {
		this.valueIndex = valueIndex;
	}

	public String getValueDim() {
		return valueDim;
	}

	public void setValueDim(String valueDim) {
		this.valueDim = valueDim;
	}

	public List<Object> getCoord() {
		return coord;
	}

	public void setCoord(List<Object> coord) {
		this.coord = coord;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}