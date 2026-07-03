package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.yalantis.ucrop.C11199R;
import java.util.Objects;
import p007b.p485q.p486a.p491l.C5308d;
import p007b.p485q.p486a.p491l.C5309e;

/* JADX INFO: loaded from: classes3.dex */
public class UCropView extends FrameLayout {

    /* JADX INFO: renamed from: j */
    public GestureCropImageView f22241j;

    /* JADX INFO: renamed from: k */
    public final OverlayView f22242k;

    public UCropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        LayoutInflater.from(context).inflate(C11199R.e.ucrop_view, (ViewGroup) this, true);
        this.f22241j = (GestureCropImageView) findViewById(C11199R.d.image_view_crop);
        OverlayView overlayView = (OverlayView) findViewById(C11199R.d.view_overlay);
        this.f22242k = overlayView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11199R.h.ucrop_UCropView);
        Objects.requireNonNull(overlayView);
        overlayView.f22235u = typedArrayObtainStyledAttributes.getBoolean(C11199R.h.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        int color = typedArrayObtainStyledAttributes.getColor(C11199R.h.ucrop_UCropView_ucrop_dimmed_color, overlayView.getResources().getColor(C11199R.a.ucrop_color_default_dimmed));
        overlayView.f22236v = color;
        overlayView.f22238x.setColor(color);
        overlayView.f22238x.setStyle(Paint.Style.STROKE);
        overlayView.f22238x.setStrokeWidth(1.0f);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C11199R.h.ucrop_UCropView_ucrop_frame_stroke_size, overlayView.getResources().getDimensionPixelSize(C11199R.b.ucrop_default_crop_frame_stoke_width));
        int color2 = typedArrayObtainStyledAttributes.getColor(C11199R.h.ucrop_UCropView_ucrop_frame_color, overlayView.getResources().getColor(C11199R.a.ucrop_color_default_crop_frame));
        overlayView.f22240z.setStrokeWidth(dimensionPixelSize);
        overlayView.f22240z.setColor(color2);
        overlayView.f22240z.setStyle(Paint.Style.STROKE);
        overlayView.f22214A.setStrokeWidth(dimensionPixelSize * 3);
        overlayView.f22214A.setColor(color2);
        overlayView.f22214A.setStyle(Paint.Style.STROKE);
        overlayView.f22233s = typedArrayObtainStyledAttributes.getBoolean(C11199R.h.ucrop_UCropView_ucrop_show_frame, true);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(C11199R.h.ucrop_UCropView_ucrop_grid_stroke_size, overlayView.getResources().getDimensionPixelSize(C11199R.b.ucrop_default_crop_grid_stoke_width));
        int color3 = typedArrayObtainStyledAttributes.getColor(C11199R.h.ucrop_UCropView_ucrop_grid_color, overlayView.getResources().getColor(C11199R.a.ucrop_color_default_crop_grid));
        overlayView.f22239y.setStrokeWidth(dimensionPixelSize2);
        overlayView.f22239y.setColor(color3);
        overlayView.f22229o = typedArrayObtainStyledAttributes.getInt(C11199R.h.ucrop_UCropView_ucrop_grid_row_count, 2);
        overlayView.f22230p = typedArrayObtainStyledAttributes.getInt(C11199R.h.ucrop_UCropView_ucrop_grid_column_count, 2);
        overlayView.f22234t = typedArrayObtainStyledAttributes.getBoolean(C11199R.h.ucrop_UCropView_ucrop_show_grid, true);
        GestureCropImageView gestureCropImageView = this.f22241j;
        Objects.requireNonNull(gestureCropImageView);
        float fAbs = Math.abs(typedArrayObtainStyledAttributes.getFloat(C11199R.h.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0f));
        float fAbs2 = Math.abs(typedArrayObtainStyledAttributes.getFloat(C11199R.h.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0f));
        if (fAbs == 0.0f || fAbs2 == 0.0f) {
            gestureCropImageView.f14454A = 0.0f;
        } else {
            gestureCropImageView.f14454A = fAbs / fAbs2;
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f22241j.setCropBoundsChangeListener(new C5308d(this));
        overlayView.setOverlayViewChangeListener(new C5309e(this));
    }

    @NonNull
    public GestureCropImageView getCropImageView() {
        return this.f22241j;
    }

    @NonNull
    public OverlayView getOverlayView() {
        return this.f22242k;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
