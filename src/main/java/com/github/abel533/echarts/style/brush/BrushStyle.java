/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2015 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.github.abel533.echarts.style.brush;

import java.io.Serializable;

/**
 * @author liuzh
 */
public class BrushStyle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1118264078494051101L;
	/**
	 * 颜色
	 */
	private Object color;

	/**
	 * 线宽
	 */
	private Integer width;

	/**
	 * 
	 */
	private Object borderWidth;

	private Object borderColor;

	public Object color() {
		return color;
	}

	public BrushStyle color(Object color) {
		this.color = color;
		return this;
	}

	public Integer width() {
		return width;
	}

	public BrushStyle width(Integer width) {
		this.width = width;
		return this;
	}

	public Object borderWidth() {
		return borderWidth;
	}

	public BrushStyle borderWidth(Object borderWidth) {
		this.borderWidth = borderWidth;
		return this;
	}

	public Object borderColor() {
		return borderColor;
	}

	public BrushStyle borderColor(Object borderColor) {
		this.borderColor = borderColor;
		return this;
	}

	public Object getColor() {
		return color;
	}

	public void setColor(Object color) {
		this.color = color;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Object getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(Object borderWidth) {
		this.borderWidth = borderWidth;
	}

	public Object getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Object borderColor) {
		this.borderColor = borderColor;
	}
}
