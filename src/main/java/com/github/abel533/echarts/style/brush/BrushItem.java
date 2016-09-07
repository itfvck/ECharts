package com.github.abel533.echarts.style.brush;

import java.io.Serializable;

import com.github.abel533.echarts.code.Symbol;

public class BrushItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3072709845349882432L;

	private Symbol symbol;// : 图元的图形类别。
	private Object symbolSize;// : 图元的大小。
	private Object color;// : 图元的颜色。
	private Object colorAlpha;// : 图元的颜色的透明度。
	private Object opacity;// :图元以及其附属物（如文字标签）的透明度。colorLightness:颜色的明暗度，
	private Object colorLightness;// :颜色的明暗度，
	private Object colorSaturation;// :颜色的饱和度，
	private Object colorHue;// :颜色的色调，

	public Object colorLightness() {
		return colorLightness;
	}

	public BrushItem colorLightness(Object colorLightness) {
		this.colorLightness = colorLightness;
		return this;
	}

	public Symbol symbol() {
		return symbol;
	}

	public BrushItem symbol(Symbol symbol) {
		this.symbol = symbol;
		return this;
	}

	public Object symbolSize() {
		return symbolSize;
	}

	public BrushItem symbolSize(Object symbolSize) {
		this.symbolSize = symbolSize;
		return this;
	}

	public Object color() {
		return color;
	}

	public BrushItem color(Object color) {
		this.color = color;
		return this;
	}

	public Object colorAlpha() {
		return colorAlpha;
	}

	public BrushItem colorAlpha(Object colorAlpha) {
		this.colorAlpha = colorAlpha;
		return this;
	}

	public Object opacity() {
		return opacity;
	}

	public BrushItem opacity(Object opacity) {
		this.opacity = opacity;
		return this;
	}

	public Object colorSaturation() {
		return colorSaturation;
	}

	public BrushItem colorSaturation(Object colorSaturation) {
		this.colorSaturation = colorSaturation;
		return this;
	}

	public Object colorHue() {
		return colorHue;
	}

	public BrushItem colorHue(Object colorHue) {
		this.colorHue = colorHue;
		return this;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}

	public Object getSymbolSize() {
		return symbolSize;
	}

	public void setSymbolSize(Object symbolSize) {
		this.symbolSize = symbolSize;
	}

	public Object getColor() {
		return color;
	}

	public void setColor(Object color) {
		this.color = color;
	}

	public Object getColorAlpha() {
		return colorAlpha;
	}

	public void setColorAlpha(Object colorAlpha) {
		this.colorAlpha = colorAlpha;
	}

	public Object getOpacity() {
		return opacity;
	}

	public void setOpacity(Object opacity) {
		this.opacity = opacity;
	}

	public Object getColorSaturation() {
		return colorSaturation;
	}

	public void setColorSaturation(Object colorSaturation) {
		this.colorSaturation = colorSaturation;
	}

	public Object getColorHue() {
		return colorHue;
	}

	public void setColorHue(Object colorHue) {
		this.colorHue = colorHue;
	}
}
