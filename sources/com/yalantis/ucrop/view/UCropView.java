package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint$Style;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import b.q.a.l.d;
import b.q.a.l.e;
import com.yalantis.ucrop.R$a;
import com.yalantis.ucrop.R$b;
import com.yalantis.ucrop.R$d;
import com.yalantis.ucrop.R$e;
import com.yalantis.ucrop.R$h;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class UCropView extends FrameLayout {
    public GestureCropImageView j;
    public final OverlayView k;

    public UCropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        LayoutInflater.from(context).inflate(R$e.ucrop_view, (ViewGroup) this, true);
        this.j = (GestureCropImageView) findViewById(R$d.image_view_crop);
        OverlayView overlayView = (OverlayView) findViewById(R$d.view_overlay);
        this.k = overlayView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$h.ucrop_UCropView);
        Objects.requireNonNull(overlayView);
        overlayView.u = typedArrayObtainStyledAttributes.getBoolean(R$h.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        int color = typedArrayObtainStyledAttributes.getColor(R$h.ucrop_UCropView_ucrop_dimmed_color, overlayView.getResources().getColor(R$a.ucrop_color_default_dimmed));
        overlayView.v = color;
        overlayView.f3183x.setColor(color);
        overlayView.f3183x.setStyle(Paint$Style.STROKE);
        overlayView.f3183x.setStrokeWidth(1.0f);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$h.ucrop_UCropView_ucrop_frame_stroke_size, overlayView.getResources().getDimensionPixelSize(R$b.ucrop_default_crop_frame_stoke_width));
        int color2 = typedArrayObtainStyledAttributes.getColor(R$h.ucrop_UCropView_ucrop_frame_color, overlayView.getResources().getColor(R$a.ucrop_color_default_crop_frame));
        overlayView.f3185z.setStrokeWidth(dimensionPixelSize);
        overlayView.f3185z.setColor(color2);
        overlayView.f3185z.setStyle(Paint$Style.STROKE);
        overlayView.A.setStrokeWidth(dimensionPixelSize * 3);
        overlayView.A.setColor(color2);
        overlayView.A.setStyle(Paint$Style.STROKE);
        overlayView.f3182s = typedArrayObtainStyledAttributes.getBoolean(R$h.ucrop_UCropView_ucrop_show_frame, true);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$h.ucrop_UCropView_ucrop_grid_stroke_size, overlayView.getResources().getDimensionPixelSize(R$b.ucrop_default_crop_grid_stoke_width));
        int color3 = typedArrayObtainStyledAttributes.getColor(R$h.ucrop_UCropView_ucrop_grid_color, overlayView.getResources().getColor(R$a.ucrop_color_default_crop_grid));
        overlayView.f3184y.setStrokeWidth(dimensionPixelSize2);
        overlayView.f3184y.setColor(color3);
        overlayView.o = typedArrayObtainStyledAttributes.getInt(R$h.ucrop_UCropView_ucrop_grid_row_count, 2);
        overlayView.p = typedArrayObtainStyledAttributes.getInt(R$h.ucrop_UCropView_ucrop_grid_column_count, 2);
        overlayView.t = typedArrayObtainStyledAttributes.getBoolean(R$h.ucrop_UCropView_ucrop_show_grid, true);
        GestureCropImageView gestureCropImageView = this.j;
        Objects.requireNonNull(gestureCropImageView);
        float fAbs = Math.abs(typedArrayObtainStyledAttributes.getFloat(R$h.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0f));
        float fAbs2 = Math.abs(typedArrayObtainStyledAttributes.getFloat(R$h.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0f));
        if (fAbs == 0.0f || fAbs2 == 0.0f) {
            gestureCropImageView.A = 0.0f;
        } else {
            gestureCropImageView.A = fAbs / fAbs2;
        }
        typedArrayObtainStyledAttributes.recycle();
        this.j.setCropBoundsChangeListener(new d(this));
        overlayView.setOverlayViewChangeListener(new e(this));
    }

    @NonNull
    public GestureCropImageView getCropImageView() {
        return this.j;
    }

    @NonNull
    public OverlayView getOverlayView() {
        return this.k;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
