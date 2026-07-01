package com.jaredrummler.android.colorpicker;

import android.R$attr;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader$TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View$MeasureSpec;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import b.i.a.f.e.o.f;
import b.k.a.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.material.badge.BadgeDrawable;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPanelView extends View {
    public Drawable j;
    public Paint k;
    public Paint l;
    public Paint m;
    public Paint n;
    public Rect o;
    public Rect p;
    public RectF q;
    public boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3142s;
    public int t;
    public int u;

    public ColorPanelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.q = new RectF();
        this.f3142s = -9539986;
        this.t = ViewCompat.MEASURED_STATE_MASK;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$f.ColorPanelView);
        this.u = typedArrayObtainStyledAttributes.getInt(R$f.ColorPanelView_cpv_colorShape, 1);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R$f.ColorPanelView_cpv_showOldColor, false);
        this.r = z2;
        if (z2 && this.u != 1) {
            throw new IllegalStateException("Color preview is only available in circle mode");
        }
        this.f3142s = typedArrayObtainStyledAttributes.getColor(R$f.ColorPanelView_cpv_borderColor, -9539986);
        typedArrayObtainStyledAttributes.recycle();
        if (this.f3142s == -9539986) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(new TypedValue().data, new int[]{R$attr.textColorSecondary});
            this.f3142s = typedArrayObtainStyledAttributes2.getColor(0, this.f3142s);
            typedArrayObtainStyledAttributes2.recycle();
        }
        Paint paint = new Paint();
        this.k = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.l = paint2;
        paint2.setAntiAlias(true);
        if (this.r) {
            this.n = new Paint();
        }
        if (this.u == 1) {
            Bitmap bitmap = ((BitmapDrawable) context.getResources().getDrawable(R$b.cpv_alpha)).getBitmap();
            Paint paint3 = new Paint();
            this.m = paint3;
            paint3.setAntiAlias(true);
            Shader$TileMode shader$TileMode = Shader$TileMode.REPEAT;
            this.m.setShader(new BitmapShader(bitmap, shader$TileMode, shader$TileMode));
        }
    }

    public void a() {
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
        if (Color.alpha(this.t) != 255) {
            sb.append(Integer.toHexString(this.t).toUpperCase(Locale.ENGLISH));
        } else {
            sb.append(String.format("%06X", Integer.valueOf(16777215 & this.t)).toUpperCase(Locale.ENGLISH));
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
        return this.f3142s;
    }

    public int getColor() {
        return this.t;
    }

    public int getShape() {
        return this.u;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.k.setColor(this.f3142s);
        this.l.setColor(this.t);
        int i = this.u;
        if (i == 0) {
            Drawable drawable = this.j;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            canvas.drawRect(this.p, this.l);
            return;
        }
        if (i == 1) {
            int measuredWidth = getMeasuredWidth() / 2;
            if (Color.alpha(this.t) < 255) {
                canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth + 0, this.m);
            }
            if (!this.r) {
                canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth + 0, this.l);
            } else {
                canvas.drawArc(this.q, 90.0f, 180.0f, true, this.n);
                canvas.drawArc(this.q, 270.0f, 180.0f, true, this.l);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.u;
        if (i3 == 0) {
            setMeasuredDimension(View$MeasureSpec.getSize(i), View$MeasureSpec.getSize(i2));
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
            this.t = bundle.getInt(ModelAuditLogEntry.CHANGE_KEY_COLOR);
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt(ModelAuditLogEntry.CHANGE_KEY_COLOR, this.t);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.u == 0 || this.r) {
            Rect rect = new Rect();
            this.o = rect;
            rect.left = getPaddingLeft();
            this.o.right = i - getPaddingRight();
            this.o.top = getPaddingTop();
            this.o.bottom = i2 - getPaddingBottom();
            if (this.r) {
                Rect rect2 = this.o;
                this.q = new RectF(rect2.left + 0, rect2.top + 0, rect2.right + 0, rect2.bottom + 0);
                return;
            }
            Rect rect3 = this.o;
            this.p = new Rect(rect3.left + 0, rect3.top + 0, rect3.right + 0, rect3.bottom + 0);
            a aVar = new a(f.S(getContext(), 4.0f));
            this.j = aVar;
            aVar.setBounds(Math.round(this.p.left), Math.round(this.p.top), Math.round(this.p.right), Math.round(this.p.bottom));
        }
    }

    public void setBorderColor(int i) {
        this.f3142s = i;
        invalidate();
    }

    public void setColor(int i) {
        this.t = i;
        invalidate();
    }

    public void setOriginalColor(@ColorInt int i) {
        Paint paint = this.n;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    public void setShape(int i) {
        this.u = i;
        invalidate();
    }
}
