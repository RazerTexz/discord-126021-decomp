package com.lytefast.flexinput.adapters;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.discord.utilities.drawable.DrawableCompat;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lytefast.flexinput.R$b;
import com.lytefast.flexinput.R$g;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import com.lytefast.flexinput.utils.SelectionCoordinator$a;
import d0.g0.t;
import d0.g0.w;
import d0.t.n;
import d0.z.d.m;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: compiled from: FileListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FileListAdapter extends RecyclerView$Adapter<FileListAdapter$b> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final SelectionCoordinator<?, ? super Attachment<? extends File>> selectionCoordinator;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public List<? extends Attachment<? extends File>> files;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final ContentResolver contentResolver;

    public FileListAdapter(ContentResolver contentResolver, SelectionCoordinator<?, Attachment<File>> selectionCoordinator) {
        m.checkNotNullParameter(contentResolver, "contentResolver");
        m.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
        this.contentResolver = contentResolver;
        Objects.requireNonNull(selectionCoordinator);
        m.checkNotNullParameter(this, "adapter");
        selectionCoordinator.adapter = this;
        this.selectionCoordinator = selectionCoordinator;
        this.files = n.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.files.size();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x00e1  */
    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        String mimeTypeFromExtension;
        String str;
        FileListAdapter$b fileListAdapter$b = (FileListAdapter$b) recyclerView$ViewHolder;
        m.checkNotNullParameter(fileListAdapter$b, "holder");
        Attachment<? extends File> attachment = this.files.get(i);
        Objects.requireNonNull(fileListAdapter$b);
        m.checkNotNullParameter(attachment, "fileAttachment");
        fileListAdapter$b.g = attachment;
        fileListAdapter$b.b(fileListAdapter$b.h.selectionCoordinator.a(attachment, fileListAdapter$b.getAdapterPosition()), false);
        File data = attachment.getData();
        if (data != null) {
            fileListAdapter$b.e.setText(data.getName());
            TextView textView = fileListAdapter$b.f;
            m.checkNotNullParameter(data, "$this$getFileSize");
            long j = 1024;
            long length = data.length() / j;
            if (length < j) {
                str = length + " KB";
            } else {
                long j2 = length / j;
                if (j2 < j) {
                    str = j2 + " MB";
                } else {
                    str = (j2 / j) + " GB";
                }
            }
            textView.setText(str);
        } else {
            fileListAdapter$b.e.setText((CharSequence) null);
            fileListAdapter$b.f.setText((CharSequence) null);
        }
        SimpleDraweeView simpleDraweeView = fileListAdapter$b.c;
        simpleDraweeView.setImageURI((Uri) null, simpleDraweeView.getContext());
        fileListAdapter$b.d.setVisibility(8);
        boolean z2 = true;
        if (data != null) {
            Objects.requireNonNull(fileListAdapter$b.h);
            String name = data.getName();
            m.checkNotNullExpressionValue(name, "fileName");
            int iLastIndexOf$default = w.lastIndexOf$default((CharSequence) name, '.', 0, false, 6, (Object) null) + 1;
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = name.substring(iLastIndexOf$default);
            m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            if (TextUtils.isEmpty(strSubstring)) {
                mimeTypeFromExtension = null;
            } else {
                mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(strSubstring);
            }
        } else {
            mimeTypeFromExtension = null;
        }
        if (mimeTypeFromExtension != null && mimeTypeFromExtension.length() != 0) {
            z2 = false;
        }
        if (z2) {
            return;
        }
        fileListAdapter$b.c.setImageURI(Uri.fromFile(data), fileListAdapter$b.c.getContext());
        if (t.startsWith$default(mimeTypeFromExtension, "image", false, 2, null)) {
            ImageView imageView = fileListAdapter$b.d;
            imageView.setImageResource(DrawableCompat.getThemedDrawableRes$default(imageView, R$b.ic_flex_input_image, 0, 2, (Object) null));
            fileListAdapter$b.d.setVisibility(0);
            fileListAdapter$b.a(data);
            return;
        }
        if (t.startsWith$default(mimeTypeFromExtension, MediaStreamTrack.VIDEO_TRACK_KIND, false, 2, null)) {
            ImageView imageView2 = fileListAdapter$b.d;
            imageView2.setImageResource(DrawableCompat.getThemedDrawableRes$default(imageView2, R$b.ic_flex_input_movie, 0, 2, (Object) null));
            fileListAdapter$b.d.setVisibility(0);
            fileListAdapter$b.a(data);
            return;
        }
        if (t.startsWith$default(mimeTypeFromExtension, MediaStreamTrack.AUDIO_TRACK_KIND, false, 2, null)) {
            ImageView imageView3 = fileListAdapter$b.d;
            imageView3.setImageResource(DrawableCompat.getThemedDrawableRes$default(imageView3, R$b.ic_flex_input_audio, 0, 2, (Object) null));
            fileListAdapter$b.d.setVisibility(0);
            fileListAdapter$b.a(data);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        m.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$g.view_file_item, viewGroup, false);
        m.checkNotNullExpressionValue(viewInflate, "view");
        return new FileListAdapter$b(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i, List list) {
        Object next;
        FileListAdapter$b fileListAdapter$b = (FileListAdapter$b) recyclerView$ViewHolder;
        m.checkNotNullParameter(fileListAdapter$b, "holder");
        m.checkNotNullParameter(list, "payloads");
        Iterator it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(next instanceof SelectionCoordinator$a));
        if (next != null) {
            SelectionCoordinator$a selectionCoordinator$a = (SelectionCoordinator$a) (next instanceof SelectionCoordinator$a ? next : null);
            if (selectionCoordinator$a != null) {
                fileListAdapter$b.b(selectionCoordinator$a.f3171b, true);
                return;
            }
        }
        super.onBindViewHolder(fileListAdapter$b, i, list);
    }
}
