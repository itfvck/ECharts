package com.github.abel533.echarts;

import com.github.abel533.echarts.style.brush.BrushStyle;
import com.github.abel533.echarts.style.brush.InBrush;
import com.github.abel533.echarts.style.brush.OutOfBrush;

/**
 * brush 是区域选择组件，用户可以选择图中一部分数据，从而便于向用户展示被选中数据，或者他们的一些统计计算结果。
 * 
 * @author vcdemon
 * @time 2016年9月7日 上午10:49:06
 */
public class Brush extends Basic<Brush> implements Component {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6095861138075558860L;

	/**
	 * brush 相关的 toolbox 按钮有： <br>
	 * 'rect'：开启矩形选框选择功能。 <br>
	 * 'polygon'：开启任意形状选框选择功能。 <br>
	 * 'lineX'：开启横向选择功能。 <br>
	 * 'lineY'：开启纵向选择功能。 <br>
	 * 'keep'：切换『单选』和『多选』模式。后者可支持同时画多个选框。前者支持单击清除所有选框。 <br>
	 * 'clear'：清空所有选框。
	 */
	private String[] toolbox;

	/**
	 * 不同系列间，选中的项可以联动。brushLink 配置项是一个数组，内容是 seriesIndex，指定了哪些 series 可以被联动。 <br>
	 * 例如可以是： [3, 4, 5] 表示 seriesIndex 为 3, 4, 5 的 series 可以被联动。 <br>
	 * 'all' 表示所有 series 都进行 brushLink。 <br>
	 * 'none' 或 null 或 undefined 表示不启用 brushLink 功能。
	 * 
	 */
	private Object brushLink;

	/**
	 * 指定哪些 series 可以被刷选， <br>
	 * 可取值为： 'all': 所有 series <br>
	 * 'Array': series index 列表 <br>
	 * 'number': 某个 series index
	 */
	private Object seriesIndex;

	/**
	 * 指定哪些 geo 可以被刷选。<br>
	 * 'all'，表示所有 <br>
	 * number，如 0，表示这个 index 所对应的坐标系。 <br>
	 * Array，如 [0, 4, 2]，表示指定这些 index 所对应的坐标系。<br>
	 * 'none' 或 null 或 undefined，表示不指定。
	 */
	private Object geoIndex;

	/**
	 * 指定哪些 xAxisIndex 可以被刷选。可以设置 brush 是『全局的』还是『属于坐标系的』。<br>
	 * 'all'，表示所有<br>
	 * number，如 0，表示这个 index 所对应的坐标系。<br>
	 * Array，如 [0, 4, 2]，表示指定这些 index 所对应的坐标系。<br>
	 * 'none' 或 null 或 undefined，表示不指定。
	 */
	private Object xAxisIndex;
	/**
	 * 
	 * 指定哪些 yAxisIndex 可以被刷选。 可以设置 brush 是『全局的』还是『属于坐标系的』。<br>
	 * 'all'，表示所有<br>
	 * number，如 0，表示这个 index 所对应的坐标系。<br>
	 * Array，如 [0, 4, 2]，表示指定这些 index 所对应的坐标系。<br>
	 * 'none' 或 null 或 undefined，表示不指定。
	 */
	private Object yAxisIndex;

	/**
	 * 默认的刷子类型。 'rect'：矩形选框。 'polygon'：任意形状选框。 'lineX'：横向选择。 'lineY'：纵向选择。
	 * 
	 */
	private String brushType = "rect";

	/**
	 * 默认的刷子的模式。可取值为： 'single'：单选。 'multiple'：多选。
	 */
	private String brushMode = "single";

	/**
	 * 已经选好的选框是否可以被调整形状或平移。
	 */
	private Boolean transformable = Boolean.TRUE;

	/**
	 * 选框的默认样式
	 */
	private BrushStyle brushStyle;

	/**
	 * 默认情况，刷选或者移动选区的时候，会不断得发 brushSelected 事件，从而告诉外界选中的内容。<br>
	 * 但是频繁的事件可能导致性能问题，或者动画效果很差。所以 brush 组件提供了 brush.throttleType，brush.throttleDelay 来解决这个问题。<br>
	 * 'debounce'：表示只有停止动作了（即一段时间没有操作了），才会触发事件。时间阈值由 brush.throttleDelay 指定。<br>
	 * 'fixRate'：表示按照一定的频率触发时间，时间间隔由 brush.throttleDelay 指定。
	 */
	private String throttleType;

	/**
	 * 默认为 0 表示不开启 throttle。<br>
	 * 默认情况，刷选或者移动选区的时候，会不断得发 brushSelected 事件，从而告诉外界选中的内容。<br>
	 * 但是频繁的事件可能导致性能问题，或者动画效果很差。所以 brush 组件提供了 brush.throttleType，brush.throttleDelay 来解决这个问题。<br>
	 * throttleType 取值可以是：<br>
	 * 'debounce'：表示只有停止动作了（即一段时间没有操作了），才会触发事件。时间阈值由 brush.throttleDelay 指定。<br>
	 * 'fixRate'：表示按照一定的频率触发时间，时间间隔由 brush.throttleDelay 指定。<br>
	 */
	private Double throttleDelay = 0D;

	/**
	 * 在 brush.brushMode 为 'single' 的情况下，是否支持『单击清除所有选框』。
	 */
	private Boolean removeOnClick = true;

	/**
	 * 定义 在选中范围中 的视觉元素。<br>
	 * 可选的视觉元素有：<br>
	 * symbol: 图元的图形类别。<br>
	 * symbolSize: 图元的大小。<br>
	 * color: 图元的颜色。<br>
	 * colorAlpha: 图元的颜色的透明度。<br>
	 * opacity: 图元以及其附属物（如文字标签）的透明度。<br>
	 * colorLightness: 颜色的明暗度，参见 HSL。<br>
	 * colorSaturation: 颜色的饱和度，参见 HSL。<br>
	 * colorHue: 颜色的色调，参见 HSL。<br>
	 * 大多数情况下，inBrush 可以不指定，维持本来的视觉配置。<br>
	 */
	private InBrush inBrush;

	/**
	 * 定义 在选中范围外 的视觉元素。
	 */
	private OutOfBrush outOfBrush;

	public OutOfBrush outOfBrush() {
		return outOfBrush;
	}

	public Brush outOfBrush(OutOfBrush outOfBrush) {
		this.outOfBrush = outOfBrush;
		return this;
	}

	public OutOfBrush getOutOfBrush() {
		return outOfBrush;
	}

	public void setOutOfBrush(OutOfBrush outOfBrush) {
		this.outOfBrush = outOfBrush;
	}

	public InBrush inBrush() {
		return inBrush;
	}

	public Brush inBrush(InBrush inBrush) {
		this.inBrush = inBrush;
		return this;
	}

	public Object getInBrush() {
		return inBrush;
	}

	public void setInBrush(InBrush inBrush) {
		this.inBrush = inBrush;
	}

	public Boolean removeOnClick() {
		return removeOnClick;
	}

	public Brush removeOnClick(Boolean removeOnClick) {
		this.removeOnClick = removeOnClick;
		return this;
	}

	public Boolean getRemoveOnClick() {
		return removeOnClick;
	}

	public void setRemoveOnClick(Boolean removeOnClick) {
		this.removeOnClick = removeOnClick;
	}

	public Double throttleDelay() {
		return throttleDelay;
	}

	public Brush throttleDelay(Double throttleDelay) {
		this.throttleDelay = throttleDelay;
		return this;
	}

	public Double getThrottleDelay() {
		return throttleDelay;
	}

	public void setThrottleDelay(Double throttleDelay) {
		this.throttleDelay = throttleDelay;
	}

	public String throttleType() {
		return throttleType;
	}

	public Brush throttleType(String throttleType) {
		this.throttleType = throttleType;
		return this;
	}

	public String getThrottleType() {
		return throttleType;
	}

	public void setThrottleType(String throttleType) {
		this.throttleType = throttleType;
	}

	public void setBrushStyle(BrushStyle brushStyle) {
		this.brushStyle = brushStyle;
	}

	public Object getBrushStyle() {
		return brushStyle;
	}

	public Brush brushStyle(BrushStyle brushStyle) {
		this.brushStyle = brushStyle;
		return this;
	}

	public Boolean transformable() {
		return transformable;
	}

	public Brush transformable(Boolean transformable) {
		this.transformable = transformable;
		return this;
	}

	public Boolean getTransformable() {
		return transformable;
	}

	public void setTransformable(Boolean transformable) {
		this.transformable = transformable;
	}

	public String brushMode() {
		return brushMode;
	}

	public Brush brushMode(String brushMode) {
		this.brushMode = brushMode;
		return this;
	}

	public String getBrushMode() {
		return brushMode;
	}

	public void setBrushMode(String brushMode) {
		this.brushMode = brushMode;
	}

	public String brushType() {
		return brushType;
	}

	public Brush brushType(String brushType) {
		this.brushType = brushType;
		return this;
	}

	public String getBrushType() {
		return brushType;
	}

	public void setBrushType(String brushType) {
		this.brushType = brushType;
	}

	public Object yAxisIndex() {
		return yAxisIndex;
	}

	public Brush yAxisIndex(Object yAxisIndex) {
		this.yAxisIndex = yAxisIndex;
		return this;
	}

	public Object getyAxisIndex() {
		return yAxisIndex;
	}

	public void setyAxisIndex(Object yAxisIndex) {
		this.yAxisIndex = yAxisIndex;
	}

	public Object xAxisIndex() {
		return xAxisIndex;
	}

	public Brush xAxisIndex(Object xAxisIndex) {
		this.xAxisIndex = xAxisIndex;
		return this;
	}

	public Object getxAxisIndex() {
		return xAxisIndex;
	}

	public void setxAxisIndex(Object xAxisIndex) {
		this.xAxisIndex = xAxisIndex;
	}

	public Object geoIndex() {
		return geoIndex;
	}

	public Brush geoIndex(Object geoIndex) {
		this.geoIndex = geoIndex;
		return this;
	}

	public Object getGeoIndex() {
		return geoIndex;
	}

	public void setGeoIndex(Object geoIndex) {
		this.geoIndex = geoIndex;
	}

	public Object seriesIndex() {
		return seriesIndex;
	}

	public Brush seriesIndex(Object seriesIndex) {
		this.seriesIndex = seriesIndex;
		return this;
	}

	public Object getSeriesIndex() {
		return seriesIndex;
	}

	public void setSeriesIndex(Object seriesIndex) {
		this.seriesIndex = seriesIndex;
	}

	public Object brushLink() {
		return brushLink;
	}

	public Brush brushLink(Object brushLink) {
		this.brushLink = brushLink;
		return this;
	}

	public Object getBrushLink() {
		return brushLink;
	}

	public void setBrushLink(Object brushLink) {
		this.brushLink = brushLink;
	}

	public String[] toolbox() {
		return toolbox;
	}

	public Brush toolbox(String[] toolbox) {
		this.toolbox = toolbox;
		return this;

	}

	public String[] getToolbox() {
		return toolbox;
	}

	public void setToolbox(String[] toolbox) {
		this.toolbox = toolbox;
	}

}
