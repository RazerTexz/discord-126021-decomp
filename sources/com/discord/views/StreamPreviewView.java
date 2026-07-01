package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.a.i.z3;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.stores.StoreApplicationStreamPreviews$StreamPreview;
import com.discord.stores.StoreApplicationStreamPreviews$StreamPreview$Fetching;
import com.discord.stores.StoreApplicationStreamPreviews$StreamPreview$Resolved;
import com.discord.utilities.streams.StreamContext$Joinability;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: StreamPreviewView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StreamPreviewView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final z3 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.view_stream_preview, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.stream_preview_image;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R$id.stream_preview_image);
        if (simpleDraweeView != null) {
            i = R$id.stream_preview_overlay_text;
            TextView textView = (TextView) viewInflate.findViewById(R$id.stream_preview_overlay_text);
            if (textView != null) {
                i = R$id.stream_preview_placeholder_caption;
                TextView textView2 = (TextView) viewInflate.findViewById(R$id.stream_preview_placeholder_caption);
                if (textView2 != null) {
                    z3 z3Var = new z3((ConstraintLayout) viewInflate, simpleDraweeView, textView, textView2);
                    m.checkNotNullExpressionValue(z3Var, "ViewStreamPreviewBinding…rom(context), this, true)");
                    this.binding = z3Var;
                    setClickable(true);
                    setFocusable(false);
                    setFocusableInTouchMode(false);
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void setCaptionText(CharSequence text) {
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.streamPreviewPlaceholderCaption");
        ViewExtensions.setTextAndVisibilityBy(textView, text);
    }

    private final void setImage(String url) {
        this.binding.f240b.setImageURI(url);
    }

    private final void setOverlayCaptionText(CharSequence text) {
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.streamPreviewOverlayText");
        ViewExtensions.setTextAndVisibilityBy(textView, text);
    }

    @MainThread
    public final void a(StoreApplicationStreamPreviews$StreamPreview preview, StreamContext$Joinability joinability, boolean isAlreadyWatchingStream) {
        m.checkNotNullParameter(preview, "preview");
        m.checkNotNullParameter(joinability, "joinability");
        if (preview instanceof StoreApplicationStreamPreviews$StreamPreview$Fetching) {
            setCaptionText(getContext().getString(2131896041));
        } else {
            if (!(preview instanceof StoreApplicationStreamPreviews$StreamPreview$Resolved)) {
                throw new NoWhenBranchMatchedException();
            }
            StoreApplicationStreamPreviews$StreamPreview$Resolved storeApplicationStreamPreviews$StreamPreview$Resolved = (StoreApplicationStreamPreviews$StreamPreview$Resolved) preview;
            if (storeApplicationStreamPreviews$StreamPreview$Resolved.getUrl() != null) {
                setImage(storeApplicationStreamPreviews$StreamPreview$Resolved.getUrl());
                setCaptionText(null);
            } else {
                setImage(null);
                if (joinability == StreamContext$Joinability.CAN_CONNECT) {
                    setCaptionText(getContext().getString(2131896026));
                } else {
                    setCaptionText(null);
                }
            }
        }
        if (isAlreadyWatchingStream) {
            setOverlayCaptionText(b.j(this, 2131897199, new Object[0], null, 4));
            return;
        }
        int iOrdinal = joinability.ordinal();
        if (iOrdinal == 0) {
            setOverlayCaptionText(b.j(this, 2131892394, new Object[0], null, 4));
        } else if (iOrdinal == 1) {
            setOverlayCaptionText(b.j(this, 2131896558, new Object[0], null, 4));
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            setOverlayCaptionText(b.j(this, 2131887550, new Object[0], null, 4));
        }
    }
}
