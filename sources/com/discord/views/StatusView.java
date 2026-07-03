package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Px;
import androidx.appcompat.widget.AppCompatImageView;
import com.discord.C5419R;
import com.discord.api.presence.ClientStatus;
import com.discord.api.presence.ClientStatuses;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.utilities.presence.PresenceUtils;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StatusView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StatusView extends AppCompatImageView {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public float cornerRadius;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public Paint backgroundPaint;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public boolean showMobile;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public boolean isCircle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        this.cornerRadius = 2.0f;
        this.showMobile = true;
        this.isCircle = true;
        setAdjustViewBounds(true);
        setScaleType(ImageView.ScaleType.FIT_XY);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C5419R.a.StatusView, 0, 0);
        C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…yleable.StatusView, 0, 0)");
        try {
            setBorderWidth((int) typedArrayObtainStyledAttributes.getDimension(1, 0.0f));
            int color = typedArrayObtainStyledAttributes.getColor(0, 0);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(color);
            paint.setAntiAlias(true);
            this.backgroundPaint = paint;
            this.showMobile = typedArrayObtainStyledAttributes.getBoolean(3, true);
            this.cornerRadius = typedArrayObtainStyledAttributes.getDimension(2, 0.0f);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        C12238m.checkNotNullParameter(canvas, "canvas");
        if (this.isCircle) {
            float width = getWidth() / 2.0f;
            float height = getHeight() / 2.0f;
            float width2 = getWidth() / 2.0f;
            Paint paint = this.backgroundPaint;
            if (paint == null) {
                C12238m.throwUninitializedPropertyAccessException("backgroundPaint");
            }
            canvas.drawCircle(width, height, width2, paint);
        } else {
            float width3 = getWidth();
            float height2 = getHeight();
            float f = this.cornerRadius;
            Paint paint2 = this.backgroundPaint;
            if (paint2 == null) {
                C12238m.throwUninitializedPropertyAccessException("backgroundPaint");
            }
            canvas.drawRoundRect(0.0f, 0.0f, width3, height2, f, f, paint2);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        paint.setAntiAlias(true);
        this.backgroundPaint = paint;
    }

    public final void setBorderWidth(@Px int borderWidthPx) {
        setPadding(borderWidthPx, borderWidthPx, borderWidthPx, borderWidthPx);
    }

    public final void setCornerRadius(@Px float cornerRadius) {
        this.cornerRadius = cornerRadius;
        invalidate();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x003e  */
    public final void setPresence(Presence presence) {
        int i;
        ClientStatuses clientStatuses;
        ClientStatuses clientStatuses2;
        if (!this.showMobile || presence == null || (clientStatuses2 = presence.getClientStatuses()) == null || !PresenceUtils.INSTANCE.isMobile(clientStatuses2)) {
            if ((presence != null ? PresenceUtils.INSTANCE.getStreamingActivity(presence) : null) != null) {
                i = C5419R.drawable.ic_status_streaming_16dp;
            } else {
                ClientStatus status = presence != null ? presence.getStatus() : null;
                if (status != null) {
                    int iOrdinal = status.ordinal();
                    if (iOrdinal == 0) {
                        i = C5419R.drawable.ic_status_online_16dp;
                    } else if (iOrdinal == 1) {
                        i = C5419R.drawable.ic_status_idle_16dp;
                    } else if (iOrdinal != 2) {
                        i = C5419R.drawable.ic_status_invisible_16dp;
                    } else {
                        i = C5419R.drawable.ic_status_dnd_16dp;
                    }
                } else {
                    i = C5419R.drawable.ic_status_invisible_16dp;
                }
            }
        } else {
            i = C5419R.drawable.ic_mobile;
        }
        setImageResource(i);
        this.isCircle = !(this.showMobile && presence != null && (clientStatuses = presence.getClientStatuses()) != null && PresenceUtils.INSTANCE.isMobile(clientStatuses));
    }
}
