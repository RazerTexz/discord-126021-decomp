package com.discord.views.directories;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View$OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.f3;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: ServerDiscoveryHeader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerDiscoveryHeader extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final f3 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerDiscoveryHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_server_discovery_header, this);
        int i = R$id.server_discovery_header_description;
        TextView textView = (TextView) findViewById(R$id.server_discovery_header_description);
        if (textView != null) {
            i = R$id.server_discovery_header_image;
            ImageView imageView = (ImageView) findViewById(R$id.server_discovery_header_image);
            if (imageView != null) {
                i = R$id.server_discovery_header_search_layout;
                FrameLayout frameLayout = (FrameLayout) findViewById(R$id.server_discovery_header_search_layout);
                if (frameLayout != null) {
                    i = R$id.server_discovery_header_title;
                    TextView textView2 = (TextView) findViewById(R$id.server_discovery_header_title);
                    if (textView2 != null) {
                        f3 f3Var = new f3(this, textView, imageView, frameLayout, textView2);
                        m.checkNotNullExpressionValue(f3Var, "ViewServerDiscoveryHeade…ater.from(context), this)");
                        this.binding = f3Var;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void setButtonOnClickListener(View$OnClickListener listener) {
        this.binding.c.setOnClickListener(listener);
    }

    public final void setDescription(CharSequence description) {
        TextView textView = this.binding.f112b;
        m.checkNotNullExpressionValue(textView, "binding.serverDiscoveryHeaderDescription");
        textView.setText(description);
    }

    public final void setTitle(CharSequence title) {
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.serverDiscoveryHeaderTitle");
        textView.setText(title);
    }
}
