package com.google.android.material.shape;

import androidx.annotation.Dimension;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ShapeAppearanceModel$Builder {

    @NonNull
    private EdgeTreatment bottomEdge;

    @NonNull
    private CornerTreatment bottomLeftCorner;

    @NonNull
    private CornerSize bottomLeftCornerSize;

    @NonNull
    private CornerTreatment bottomRightCorner;

    @NonNull
    private CornerSize bottomRightCornerSize;

    @NonNull
    private EdgeTreatment leftEdge;

    @NonNull
    private EdgeTreatment rightEdge;

    @NonNull
    private EdgeTreatment topEdge;

    @NonNull
    private CornerTreatment topLeftCorner;

    @NonNull
    private CornerSize topLeftCornerSize;

    @NonNull
    private CornerTreatment topRightCorner;

    @NonNull
    private CornerSize topRightCornerSize;

    public ShapeAppearanceModel$Builder() {
        this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
    }

    public static /* synthetic */ CornerTreatment access$100(ShapeAppearanceModel$Builder shapeAppearanceModel$Builder) {
        return shapeAppearanceModel$Builder.topLeftCorner;
    }

    public static /* synthetic */ EdgeTreatment access$1000(ShapeAppearanceModel$Builder shapeAppearanceModel$Builder) {
        return shapeAppearanceModel$Builder.rightEdge;
    }

    public static /* synthetic */ EdgeTreatment access$1100(ShapeAppearanceModel$Builder shapeAppearanceModel$Builder) {
        return shapeAppearanceModel$Builder.bottomEdge;
    }

    public static /* synthetic */ EdgeTreatment access$1200(ShapeAppearanceModel$Builder shapeAppearanceModel$Builder) {
        return shapeAppearanceModel$Builder.leftEdge;
    }

    public static /* synthetic */ CornerTreatment access$200(ShapeAppearanceModel$Builder shapeAppearanceModel$Builder) {
        return shapeAppearanceModel$Builder.topRightCorner;
    }

    public static /* synthetic */ CornerTreatment access$300(ShapeAppearanceModel$Builder shapeAppearanceModel$Builder) {
        return shapeAppearanceModel$Builder.bottomRightCorner;
    }

    public static /* synthetic */ CornerTreatment access$400(ShapeAppearanceModel$Builder shapeAppearanceModel$Builder) {
        return shapeAppearanceModel$Builder.bottomLeftCorner;
    }

    public static /* synthetic */ CornerSize access$500(ShapeAppearanceModel$Builder shapeAppearanceModel$Builder) {
        return shapeAppearanceModel$Builder.topLeftCornerSize;
    }

    public static /* synthetic */ CornerSize access$600(ShapeAppearanceModel$Builder shapeAppearanceModel$Builder) {
        return shapeAppearanceModel$Builder.topRightCornerSize;
    }

    public static /* synthetic */ CornerSize access$700(ShapeAppearanceModel$Builder shapeAppearanceModel$Builder) {
        return shapeAppearanceModel$Builder.bottomRightCornerSize;
    }

    public static /* synthetic */ CornerSize access$800(ShapeAppearanceModel$Builder shapeAppearanceModel$Builder) {
        return shapeAppearanceModel$Builder.bottomLeftCornerSize;
    }

    public static /* synthetic */ EdgeTreatment access$900(ShapeAppearanceModel$Builder shapeAppearanceModel$Builder) {
        return shapeAppearanceModel$Builder.topEdge;
    }

    private static float compatCornerTreatmentSize(CornerTreatment cornerTreatment) {
        if (cornerTreatment instanceof RoundedCornerTreatment) {
            return ((RoundedCornerTreatment) cornerTreatment).radius;
        }
        if (cornerTreatment instanceof CutCornerTreatment) {
            return ((CutCornerTreatment) cornerTreatment).size;
        }
        return -1.0f;
    }

    @NonNull
    public ShapeAppearanceModel build() {
        return new ShapeAppearanceModel(this, null);
    }

    @NonNull
    public ShapeAppearanceModel$Builder setAllCornerSizes(@NonNull CornerSize cornerSize) {
        return setTopLeftCornerSize(cornerSize).setTopRightCornerSize(cornerSize).setBottomRightCornerSize(cornerSize).setBottomLeftCornerSize(cornerSize);
    }

    @NonNull
    public ShapeAppearanceModel$Builder setAllCorners(int i, @Dimension float f) {
        return setAllCorners(MaterialShapeUtils.createCornerTreatment(i)).setAllCornerSizes(f);
    }

    @NonNull
    public ShapeAppearanceModel$Builder setAllEdges(@NonNull EdgeTreatment edgeTreatment) {
        return setLeftEdge(edgeTreatment).setTopEdge(edgeTreatment).setRightEdge(edgeTreatment).setBottomEdge(edgeTreatment);
    }

    @NonNull
    public ShapeAppearanceModel$Builder setBottomEdge(@NonNull EdgeTreatment edgeTreatment) {
        this.bottomEdge = edgeTreatment;
        return this;
    }

    @NonNull
    public ShapeAppearanceModel$Builder setBottomLeftCorner(int i, @Dimension float f) {
        return setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(i)).setBottomLeftCornerSize(f);
    }

    @NonNull
    public ShapeAppearanceModel$Builder setBottomLeftCornerSize(@Dimension float f) {
        this.bottomLeftCornerSize = new AbsoluteCornerSize(f);
        return this;
    }

    @NonNull
    public ShapeAppearanceModel$Builder setBottomRightCorner(int i, @Dimension float f) {
        return setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(i)).setBottomRightCornerSize(f);
    }

    @NonNull
    public ShapeAppearanceModel$Builder setBottomRightCornerSize(@Dimension float f) {
        this.bottomRightCornerSize = new AbsoluteCornerSize(f);
        return this;
    }

    @NonNull
    public ShapeAppearanceModel$Builder setLeftEdge(@NonNull EdgeTreatment edgeTreatment) {
        this.leftEdge = edgeTreatment;
        return this;
    }

    @NonNull
    public ShapeAppearanceModel$Builder setRightEdge(@NonNull EdgeTreatment edgeTreatment) {
        this.rightEdge = edgeTreatment;
        return this;
    }

    @NonNull
    public ShapeAppearanceModel$Builder setTopEdge(@NonNull EdgeTreatment edgeTreatment) {
        this.topEdge = edgeTreatment;
        return this;
    }

    @NonNull
    public ShapeAppearanceModel$Builder setTopLeftCorner(int i, @Dimension float f) {
        return setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(i)).setTopLeftCornerSize(f);
    }

    @NonNull
    public ShapeAppearanceModel$Builder setTopLeftCornerSize(@Dimension float f) {
        this.topLeftCornerSize = new AbsoluteCornerSize(f);
        return this;
    }

    @NonNull
    public ShapeAppearanceModel$Builder setTopRightCorner(int i, @Dimension float f) {
        return setTopRightCorner(MaterialShapeUtils.createCornerTreatment(i)).setTopRightCornerSize(f);
    }

    @NonNull
    public ShapeAppearanceModel$Builder setTopRightCornerSize(@Dimension float f) {
        this.topRightCornerSize = new AbsoluteCornerSize(f);
        return this;
    }

    @NonNull
    public ShapeAppearanceModel$Builder setBottomLeftCornerSize(@NonNull CornerSize cornerSize) {
        this.bottomLeftCornerSize = cornerSize;
        return this;
    }

    @NonNull
    public ShapeAppearanceModel$Builder setBottomRightCornerSize(@NonNull CornerSize cornerSize) {
        this.bottomRightCornerSize = cornerSize;
        return this;
    }

    @NonNull
    public ShapeAppearanceModel$Builder setTopLeftCornerSize(@NonNull CornerSize cornerSize) {
        this.topLeftCornerSize = cornerSize;
        return this;
    }

    @NonNull
    public ShapeAppearanceModel$Builder setTopRightCornerSize(@NonNull CornerSize cornerSize) {
        this.topRightCornerSize = cornerSize;
        return this;
    }

    @NonNull
    public ShapeAppearanceModel$Builder setAllCorners(@NonNull CornerTreatment cornerTreatment) {
        return setTopLeftCorner(cornerTreatment).setTopRightCorner(cornerTreatment).setBottomRightCorner(cornerTreatment).setBottomLeftCorner(cornerTreatment);
    }

    @NonNull
    public ShapeAppearanceModel$Builder setBottomLeftCorner(int i, @NonNull CornerSize cornerSize) {
        return setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(i)).setBottomLeftCornerSize(cornerSize);
    }

    @NonNull
    public ShapeAppearanceModel$Builder setBottomRightCorner(int i, @NonNull CornerSize cornerSize) {
        return setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(i)).setBottomRightCornerSize(cornerSize);
    }

    @NonNull
    public ShapeAppearanceModel$Builder setTopLeftCorner(int i, @NonNull CornerSize cornerSize) {
        return setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(i)).setTopLeftCornerSize(cornerSize);
    }

    @NonNull
    public ShapeAppearanceModel$Builder setTopRightCorner(int i, @NonNull CornerSize cornerSize) {
        return setTopRightCorner(MaterialShapeUtils.createCornerTreatment(i)).setTopRightCornerSize(cornerSize);
    }

    @NonNull
    public ShapeAppearanceModel$Builder setAllCornerSizes(@Dimension float f) {
        return setTopLeftCornerSize(f).setTopRightCornerSize(f).setBottomRightCornerSize(f).setBottomLeftCornerSize(f);
    }

    @NonNull
    public ShapeAppearanceModel$Builder setBottomLeftCorner(@NonNull CornerTreatment cornerTreatment) {
        this.bottomLeftCorner = cornerTreatment;
        float fCompatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
        if (fCompatCornerTreatmentSize != -1.0f) {
            setBottomLeftCornerSize(fCompatCornerTreatmentSize);
        }
        return this;
    }

    @NonNull
    public ShapeAppearanceModel$Builder setBottomRightCorner(@NonNull CornerTreatment cornerTreatment) {
        this.bottomRightCorner = cornerTreatment;
        float fCompatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
        if (fCompatCornerTreatmentSize != -1.0f) {
            setBottomRightCornerSize(fCompatCornerTreatmentSize);
        }
        return this;
    }

    @NonNull
    public ShapeAppearanceModel$Builder setTopLeftCorner(@NonNull CornerTreatment cornerTreatment) {
        this.topLeftCorner = cornerTreatment;
        float fCompatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
        if (fCompatCornerTreatmentSize != -1.0f) {
            setTopLeftCornerSize(fCompatCornerTreatmentSize);
        }
        return this;
    }

    @NonNull
    public ShapeAppearanceModel$Builder setTopRightCorner(@NonNull CornerTreatment cornerTreatment) {
        this.topRightCorner = cornerTreatment;
        float fCompatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
        if (fCompatCornerTreatmentSize != -1.0f) {
            setTopRightCornerSize(fCompatCornerTreatmentSize);
        }
        return this;
    }

    public ShapeAppearanceModel$Builder(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.topLeftCorner = shapeAppearanceModel.topLeftCorner;
        this.topRightCorner = shapeAppearanceModel.topRightCorner;
        this.bottomRightCorner = shapeAppearanceModel.bottomRightCorner;
        this.bottomLeftCorner = shapeAppearanceModel.bottomLeftCorner;
        this.topLeftCornerSize = shapeAppearanceModel.topLeftCornerSize;
        this.topRightCornerSize = shapeAppearanceModel.topRightCornerSize;
        this.bottomRightCornerSize = shapeAppearanceModel.bottomRightCornerSize;
        this.bottomLeftCornerSize = shapeAppearanceModel.bottomLeftCornerSize;
        this.topEdge = shapeAppearanceModel.topEdge;
        this.rightEdge = shapeAppearanceModel.rightEdge;
        this.bottomEdge = shapeAppearanceModel.bottomEdge;
        this.leftEdge = shapeAppearanceModel.leftEdge;
    }
}
