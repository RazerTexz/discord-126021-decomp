package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.material.badge.BadgeDrawable;
import java.util.Locale;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p440k.p441a.p442a.C5074a;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPanelView extends View {

    /* JADX INFO: renamed from: j */
    public Drawable f21695j;

    /* JADX INFO: renamed from: k */
    public Paint f21696k;

    /* JADX INFO: renamed from: l */
    public Paint f21697l;

    /* JADX INFO: renamed from: m */
    public Paint f21698m;

    /* JADX INFO: renamed from: n */
    public Paint f21699n;

    /* JADX INFO: renamed from: o */
    public Rect f21700o;

    /* JADX INFO: renamed from: p */
    public Rect f21701p;

    /* JADX INFO: renamed from: q */
    public RectF f21702q;

    /* JADX INFO: renamed from: r */
    public boolean f21703r;

    /* JADX INFO: renamed from: s */
    public int f21704s;

    /* JADX INFO: renamed from: t */
    public int f21705t;

    /* JADX INFO: renamed from: u */
    public int f21706u;

    public ColorPanelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f21702q = new RectF();
        this.f21704s = -9539986;
        this.f21705t = ViewCompat.MEASURED_STATE_MASK;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11167R.f.ColorPanelView);
        this.f21706u = typedArrayObtainStyledAttributes.getInt(C11167R.f.ColorPanelView_cpv_colorShape, 1);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(C11167R.f.ColorPanelView_cpv_showOldColor, false);
        this.f21703r = z2;
        if (z2 && this.f21706u != 1) {
            throw new IllegalStateException("Color preview is only available in circle mode");
        }
        this.f21704s = typedArrayObtainStyledAttributes.getColor(C11167R.f.ColorPanelView_cpv_borderColor, -9539986);
        typedArrayObtainStyledAttributes.recycle();
        if (this.f21704s == -9539986) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(new TypedValue().data, new int[]{android.R.attr.textColorSecondary});
            this.f21704s = typedArrayObtainStyledAttributes2.getColor(0, this.f21704s);
            typedArrayObtainStyledAttributes2.recycle();
        }
        Paint paint = new Paint();
        this.f21696k = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f21697l = paint2;
        paint2.setAntiAlias(true);
        if (this.f21703r) {
            this.f21699n = new Paint();
        }
        if (this.f21706u == 1) {
            Bitmap bitmap = ((BitmapDrawable) context.getResources().getDrawable(C11167R.b.cpv_alpha)).getBitmap();
            Paint paint3 = new Paint();
            this.f21698m = paint3;
            paint3.setAntiAlias(true);
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.f21698m.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9266a() {
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = (height / 2) + iArr[1];
        int i2 = (width / 2) + iArr[0];
        if (ViewCompat.getLayoutDirection(this) == 0) {
            i2 = context.getResources().getDisplayMetrics().widthPixels - i2;
        }
        StringBuilder sb = new StringBuilder("#");
        if (Color.alpha(this.f21705t) != 255) {
            sb.append(Integer.toHexString(this.f21705t).toUpperCase(Locale.ENGLISH));
        } else {
            sb.append(String.format("%06X", Integer.valueOf(16777215 & this.f21705t)).toUpperCase(Locale.ENGLISH));
        }
        Toast toastMakeText = Toast.makeText(context, sb.toString(), 0);
        if (i < rect.height()) {
            toastMakeText.setGravity(BadgeDrawable.TOP_END, i2, (iArr[1] + height) - rect.top);
        } else {
            toastMakeText.setGravity(81, 0, height);
        }
        toastMakeText.show();
    }

    public int getBorderColor() {
        return this.f21704s;
    }

    public int getColor() {
        return this.f21705t;
    }

    public int getShape() {
        return this.f21706u;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f21696k.setColor(this.f21704s);
        this.f21697l.setColor(this.f21705t);
        int i = this.f21706u;
        if (i == 0) {
            Drawable drawable = this.f21695j;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            canvas.drawRect(this.f21701p, this.f21697l);
            return;
        }
        if (i == 1) {
            int measuredWidth = getMeasuredWidth() / 2;
            if (Color.alpha(this.f21705t) < 255) {
                canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth + 0, this.f21698m);
            }
            if (!this.f21703r) {
                canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth + 0, this.f21697l);
            } else {
                canvas.drawArc(this.f21702q, 90.0f, 180.0f, true, this.f21699n);
                canvas.drawArc(this.f21702q, 270.0f, 180.0f, true, this.f21697l);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.f21706u;
        if (i3 == 0) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        } else if (i3 != 1) {
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(i, i);
            setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f21705t = bundle.getInt(ModelAuditLogEntry.CHANGE_KEY_COLOR);
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt(ModelAuditLogEntry.CHANGE_KEY_COLOR, this.f21705t);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f21706u == 0 || this.f21703r) {
            Rect rect = new Rect();
            this.f21700o = rect;
            rect.left = getPaddingLeft();
            this.f21700o.right = i - getPaddingRight();
            this.f21700o.top = getPaddingTop();
            this.f21700o.bottom = i2 - getPaddingBottom();
            if (this.f21703r) {
                Rect rect2 = this.f21700o;
                this.f21702q = new RectF(rect2.left + 0, rect2.top + 0, rect2.right + 0, rect2.bottom + 0);
                return;
            }
            Rect rect3 = this.f21700o;
            this.f21701p = new Rect(rect3.left + 0, rect3.top + 0, rect3.right + 0, rect3.bottom + 0);
            C5074a c5074a = new C5074a(C3404f.m4243S(getContext(), 4.0f));
            this.f21695j = c5074a;
            c5074a.setBounds(Math.round(this.f21701p.left), Math.round(this.f21701p.top), Math.round(this.f21701p.right), Math.round(this.f21701p.bottom));
        }
    }

    public void setBorderColor(int i) {
        this.f21704s = i;
        invalidate();
    }

    public void setColor(int i) {
        this.f21705t = i;
        invalidate();
    }

    public void setOriginalColor(@ColorInt int i) {
        Paint paint = this.f21699n;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    public void setShape(int i) {
        this.f21706u = i;
        invalidate();
    }
}
