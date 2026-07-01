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
import androidx.core.app.NotificationCompat;
import b.a.i.ViewStreamPreviewBinding;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: StreamPreviewView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StreamPreviewView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final ViewStreamPreviewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_stream_preview, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.stream_preview_image;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.stream_preview_image);
        if (simpleDraweeView != null) {
            i = R.id.stream_preview_overlay_text;
            TextView textView = (TextView) viewInflate.findViewById(R.id.stream_preview_overlay_text);
            if (textView != null) {
                i = R.id.stream_preview_placeholder_caption;
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.stream_preview_placeholder_caption);
                if (textView2 != null) {
                    ViewStreamPreviewBinding viewStreamPreviewBinding = new ViewStreamPreviewBinding((ConstraintLayout) viewInflate, simpleDraweeView, textView, textView2);
                    Intrinsics3.checkNotNullExpressionValue(viewStreamPreviewBinding, "ViewStreamPreviewBinding…rom(context), this, true)");
                    this.binding = viewStreamPreviewBinding;
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
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.streamPreviewPlaceholderCaption");
        ViewExtensions.setTextAndVisibilityBy(textView, text);
    }

    private final void setImage(String url) {
        this.binding.f240b.setImageURI(url);
    }

    private final void setOverlayCaptionText(CharSequence text) {
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.streamPreviewOverlayText");
        ViewExtensions.setTextAndVisibilityBy(textView, text);
    }

    @MainThread
    public final void a(StoreApplicationStreamPreviews.StreamPreview preview, StreamContext.Joinability joinability, boolean isAlreadyWatchingStream) {
        Intrinsics3.checkNotNullParameter(preview, "preview");
        Intrinsics3.checkNotNullParameter(joinability, "joinability");
        if (preview instanceof StoreApplicationStreamPreviews.StreamPreview.Fetching) {
            setCaptionText(getContext().getString(R.string.stream_preview_loading));
        } else {
            if (!(preview instanceof StoreApplicationStreamPreviews.StreamPreview.Resolved)) {
                throw new NoWhenBranchMatchedException();
            }
            StoreApplicationStreamPreviews.StreamPreview.Resolved resolved = (StoreApplicationStreamPreviews.StreamPreview.Resolved) preview;
            if (resolved.getUrl() != null) {
                setImage(resolved.getUrl());
                setCaptionText(null);
            } else {
                setImage(null);
                if (joinability == StreamContext.Joinability.CAN_CONNECT) {
                    setCaptionText(getContext().getString(R.string.stream_no_preview));
                } else {
                    setCaptionText(null);
                }
            }
        }
        if (isAlreadyWatchingStream) {
            setOverlayCaptionText(FormatUtils.d(this, R.string.watch_stream_watching, new Object[0], (4 & 4) != 0 ? FormatUtils.c.j : null));
            return;
        }
        int iOrdinal = joinability.ordinal();
        if (iOrdinal == 0) {
            setOverlayCaptionText(FormatUtils.d(this, R.string.join_stream, new Object[0], (4 & 4) != 0 ? FormatUtils.c.j : null));
        } else if (iOrdinal == 1) {
            setOverlayCaptionText(FormatUtils.d(this, R.string.unable_to_join_channel_full, new Object[0], (4 & 4) != 0 ? FormatUtils.c.j : null));
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            setOverlayCaptionText(FormatUtils.d(this, R.string.channel_locked_short, new Object[0], (4 & 4) != 0 ? FormatUtils.c.j : null));
        }
    }
}
