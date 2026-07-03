package com.discord.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.utilities.color.ColorCompat;
import kotlin.Lazy;
import p007b.p008a.p025i.C0993k4;
import p007b.p008a.p062y.C1330f0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p508a0.C11210a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: VoiceUserLimitView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceUserLimitView extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C0993k4 binding;

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
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(C5419R.layout.voice_user_limit_view, this);
        int i = C5419R.id.voice_user_limit_current;
        TextView textView = (TextView) findViewById(C5419R.id.voice_user_limit_current);
        if (textView != null) {
            i = C5419R.id.voice_user_limit_max;
            TextView textView2 = (TextView) findViewById(C5419R.id.voice_user_limit_max);
            if (textView2 != null) {
                C0993k4 c0993k4 = new C0993k4(this, textView, textView2);
                C12238m.checkNotNullExpressionValue(c0993k4, "VoiceUserLimitViewBindin…ater.from(context), this)");
                this.binding = c0993k4;
                Paint paint = new Paint(1);
                this.paint = paint;
                Path path = new Path();
                this.path = path;
                this.point1 = new Point();
                this.point2 = new Point();
                this.point3 = new Point();
                this.videoCamDrawable = C12083g.lazy(new C1330f0(this));
                Resources resources = getResources();
                C12238m.checkNotNullExpressionValue(resources, "resources");
                this.slantWidthPx = C11210a.roundToInt(TypedValue.applyDimension(1, 6.0f, resources.getDisplayMetrics()));
                paint.setColor(ColorCompat.getThemedColor(getContext(), C5419R.attr.colorBackgroundMobilePrimary));
                paint.setStrokeWidth(2.0f);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                paint.setAntiAlias(true);
                path.setFillType(Path.FillType.EVEN_ODD);
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    private final Drawable getVideoCamDrawable() {
        return (Drawable) this.videoCamDrawable.getValue();
    }

    /* JADX INFO: renamed from: a */
    public final void m8569a(int current, int max, boolean isVideo) {
        TextView textView = this.binding.f1005b;
        C12238m.checkNotNullExpressionValue(textView, "binding.voiceUserLimitCurrent");
        textView.setText(current < 100 ? C1643a.m828P(new Object[]{Integer.valueOf(current)}, 1, "%02d", "java.lang.String.format(format, *args)") : String.valueOf(current));
        TextView textView2 = this.binding.f1006c;
        C12238m.checkNotNullExpressionValue(textView2, "binding.voiceUserLimitMax");
        textView2.setText(max < 100 ? C1643a.m828P(new Object[]{Integer.valueOf(max)}, 1, "%02d", "java.lang.String.format(format, *args)") : String.valueOf(max));
        if (isVideo) {
            this.binding.f1005b.setCompoundDrawablesWithIntrinsicBounds(getVideoCamDrawable(), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.binding.f1005b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        C12238m.checkNotNull(canvas);
        int height = getHeight();
        TextView textView = this.binding.f1005b;
        C12238m.checkNotNullExpressionValue(textView, "binding.voiceUserLimitCurrent");
        int width = textView.getWidth();
        TextView textView2 = this.binding.f1005b;
        C12238m.checkNotNullExpressionValue(textView2, "binding.voiceUserLimitCurrent");
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
