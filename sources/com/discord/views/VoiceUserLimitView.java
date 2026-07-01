package com.discord.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.Path;
import android.graphics.Path$FillType;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.k4;
import b.a.y.f0;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.utilities.color.ColorCompat;
import d0.a0.a;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;

/* JADX INFO: compiled from: VoiceUserLimitView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceUserLimitView extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final k4 binding;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final Paint paint;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final int slantWidthPx;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Path path;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final Point point1;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final Point point2;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public final Point point3;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public final Lazy videoCamDrawable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceUserLimitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R$layout.voice_user_limit_view, this);
        int i = R$id.voice_user_limit_current;
        TextView textView = (TextView) findViewById(R$id.voice_user_limit_current);
        if (textView != null) {
            i = R$id.voice_user_limit_max;
            TextView textView2 = (TextView) findViewById(R$id.voice_user_limit_max);
            if (textView2 != null) {
                k4 k4Var = new k4(this, textView, textView2);
                m.checkNotNullExpressionValue(k4Var, "VoiceUserLimitViewBindin…ater.from(context), this)");
                this.binding = k4Var;
                Paint paint = new Paint(1);
                this.paint = paint;
                Path path = new Path();
                this.path = path;
                this.point1 = new Point();
                this.point2 = new Point();
                this.point3 = new Point();
                this.videoCamDrawable = g.lazy(new f0(this));
                Resources resources = getResources();
                m.checkNotNullExpressionValue(resources, "resources");
                this.slantWidthPx = a.roundToInt(TypedValue.applyDimension(1, 6.0f, resources.getDisplayMetrics()));
                paint.setColor(ColorCompat.getThemedColor(getContext(), 2130968904));
                paint.setStrokeWidth(2.0f);
                paint.setStyle(Paint$Style.FILL_AND_STROKE);
                paint.setAntiAlias(true);
                path.setFillType(Path$FillType.EVEN_ODD);
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    private final Drawable getVideoCamDrawable() {
        return (Drawable) this.videoCamDrawable.getValue();
    }

    public final void a(int current, int max, boolean isVideo) {
        TextView textView = this.binding.f148b;
        m.checkNotNullExpressionValue(textView, "binding.voiceUserLimitCurrent");
        textView.setText(current < 100 ? b.d.b.a.a.P(new Object[]{Integer.valueOf(current)}, 1, "%02d", "java.lang.String.format(format, *args)") : String.valueOf(current));
        TextView textView2 = this.binding.c;
        m.checkNotNullExpressionValue(textView2, "binding.voiceUserLimitMax");
        textView2.setText(max < 100 ? b.d.b.a.a.P(new Object[]{Integer.valueOf(max)}, 1, "%02d", "java.lang.String.format(format, *args)") : String.valueOf(max));
        if (isVideo) {
            this.binding.f148b.setCompoundDrawablesWithIntrinsicBounds(getVideoCamDrawable(), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.binding.f148b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        m.checkNotNull(canvas);
        int height = getHeight();
        TextView textView = this.binding.f148b;
        m.checkNotNullExpressionValue(textView, "binding.voiceUserLimitCurrent");
        int width = textView.getWidth();
        TextView textView2 = this.binding.f148b;
        m.checkNotNullExpressionValue(textView2, "binding.voiceUserLimitCurrent");
        int width2 = textView2.getWidth() + this.slantWidthPx;
        this.point1.set(width, height);
        this.point2.set(width2, 0);
        this.point3.set(width, 0);
        Path path = this.path;
        Point point = this.point1;
        path.moveTo(point.x, point.y);
        Path path2 = this.path;
        Point point2 = this.point2;
        path2.lineTo(point2.x, point2.y);
        Path path3 = this.path;
        Point point3 = this.point3;
        path3.lineTo(point3.x, point3.y);
        Path path4 = this.path;
        Point point4 = this.point1;
        path4.lineTo(point4.x, point4.y);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
        this.path.reset();
    }
}
