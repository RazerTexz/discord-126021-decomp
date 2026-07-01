package com.discord.views.directories;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.ViewServerDiscoveryHeaderBinding;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ServerDiscoveryHeader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerDiscoveryHeader extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final ViewServerDiscoveryHeaderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerDiscoveryHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_server_discovery_header, this);
        int i = R.id.server_discovery_header_description;
        TextView textView = (TextView) findViewById(R.id.server_discovery_header_description);
        if (textView != null) {
            i = R.id.server_discovery_header_image;
            ImageView imageView = (ImageView) findViewById(R.id.server_discovery_header_image);
            if (imageView != null) {
                i = R.id.server_discovery_header_search_layout;
                FrameLayout frameLayout = (FrameLayout) findViewById(R.id.server_discovery_header_search_layout);
                if (frameLayout != null) {
                    i = R.id.server_discovery_header_title;
                    TextView textView2 = (TextView) findViewById(R.id.server_discovery_header_title);
                    if (textView2 != null) {
                        ViewServerDiscoveryHeaderBinding viewServerDiscoveryHeaderBinding = new ViewServerDiscoveryHeaderBinding(this, textView, imageView, frameLayout, textView2);
                        Intrinsics3.checkNotNullExpressionValue(viewServerDiscoveryHeaderBinding, "ViewServerDiscoveryHeade…ater.from(context), this)");
                        this.binding = viewServerDiscoveryHeaderBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void setButtonOnClickListener(View.OnClickListener listener) {
        this.binding.c.setOnClickListener(listener);
    }

    public final void setDescription(CharSequence description) {
        TextView textView = this.binding.f112b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverDiscoveryHeaderDescription");
        textView.setText(description);
    }

    public final void setTitle(CharSequence title) {
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverDiscoveryHeaderTitle");
        textView.setText(title);
    }
}
