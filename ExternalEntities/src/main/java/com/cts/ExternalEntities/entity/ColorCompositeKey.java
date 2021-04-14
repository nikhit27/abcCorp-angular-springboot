package com.cts.ExternalEntities.entity;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class ColorCompositeKey implements Serializable {
	
	private Integer colorId;
	private Integer modelId;
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ColorCompositeKey thisObj = (ColorCompositeKey) o;
        return colorId.equals(thisObj.colorId) &&
                modelId.equals(thisObj.modelId);
    }
	
	
	@Override
    public int hashCode() {
        return Objects.hash(colorId, modelId);
    }
	
}
