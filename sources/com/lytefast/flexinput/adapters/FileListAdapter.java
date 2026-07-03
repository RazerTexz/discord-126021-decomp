package com.lytefast.flexinput.adapters;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.discord.utilities.drawable.DrawableCompat;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lytefast.flexinput.C11170R;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.webrtc.MediaStreamTrack;
import p007b.p076b.p077a.p079d.C1435e;
import p007b.p076b.p077a.p079d.C1436f;
import p007b.p076b.p077a.p079d.C1437g;
import p007b.p076b.p077a.p082g.C1449a;
import p007b.p109f.p132g.p133a.p134a.C1731b;
import p007b.p109f.p132g.p133a.p134a.C1733d;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12153q;
import p507d0.p580t.C12160r;
import p507d0.p582u.C12169a;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: FileListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FileListAdapter extends RecyclerView.Adapter<C11174b> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final SelectionCoordinator<?, ? super Attachment<? extends File>> selectionCoordinator;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public List<? extends Attachment<? extends File>> files;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final ContentResolver contentResolver;

    /* JADX INFO: renamed from: com.lytefast.flexinput.adapters.FileListAdapter$a */
    /* JADX INFO: compiled from: FileListAdapter.kt */
    public static final class AsyncTaskC11173a extends AsyncTask<File, Boolean, List<? extends Attachment<? extends File>>> {

        /* JADX INFO: renamed from: a */
        public final FileListAdapter f22025a;

        public AsyncTaskC11173a(FileListAdapter fileListAdapter) {
            C12238m.checkNotNullParameter(fileListAdapter, "adapter");
            this.f22025a = fileListAdapter;
        }

        @Override // android.os.AsyncTask
        public List<? extends Attachment<? extends File>> doInBackground(File[] fileArr) {
            File[] fileArr2 = fileArr;
            C12238m.checkNotNullParameter(fileArr2, "rootFiles");
            File file = fileArr2[0];
            C1437g c1437g = C1437g.f2143j;
            ArrayList arrayList = new ArrayList();
            LinkedList linkedList = new LinkedList();
            C12160r.addAll(linkedList, c1437g.invoke(file));
            while (!linkedList.isEmpty()) {
                File file2 = (File) linkedList.remove();
                C12238m.checkNotNullExpressionValue(file2, "file");
                if (!file2.isHidden()) {
                    if (file2.isDirectory()) {
                        C12160r.addAll(linkedList, c1437g.invoke(file2));
                    } else {
                        arrayList.add(C1449a.m410a(file2));
                    }
                }
            }
            C12153q.sortWith(arrayList, C12169a.then(new C1436f(this), new C1435e()));
            return arrayList;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(List<? extends Attachment<? extends File>> list) {
            List<? extends Attachment<? extends File>> list2 = list;
            C12238m.checkNotNullParameter(list2, ChatInputComponentTypes.FILES);
            FileListAdapter fileListAdapter = this.f22025a;
            fileListAdapter.files = list2;
            fileListAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: com.lytefast.flexinput.adapters.FileListAdapter$b */
    /* JADX INFO: compiled from: FileListAdapter.kt */
    public class C11174b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a */
        public final AnimatorSet f22026a;

        /* JADX INFO: renamed from: b */
        public final AnimatorSet f22027b;

        /* JADX INFO: renamed from: c */
        public SimpleDraweeView f22028c;

        /* JADX INFO: renamed from: d */
        public ImageView f22029d;

        /* JADX INFO: renamed from: e */
        public TextView f22030e;

        /* JADX INFO: renamed from: f */
        public TextView f22031f;

        /* JADX INFO: renamed from: g */
        public Attachment<? extends File> f22032g;

        /* JADX INFO: renamed from: h */
        public final /* synthetic */ FileListAdapter f22033h;

        /* JADX INFO: renamed from: com.lytefast.flexinput.adapters.FileListAdapter$b$a */
        /* JADX INFO: compiled from: FileListAdapter.kt */
        public static final class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean z2;
                C11174b c11174b = C11174b.this;
                SelectionCoordinator<?, ? super Attachment<? extends File>> selectionCoordinator = c11174b.f22033h.selectionCoordinator;
                Attachment<? extends File> attachment = c11174b.f22032g;
                int adapterPosition = c11174b.getAdapterPosition();
                Objects.requireNonNull(selectionCoordinator);
                if (attachment == null || selectionCoordinator.m9301d(attachment)) {
                    z2 = false;
                } else {
                    selectionCoordinator.m9300c(attachment, adapterPosition);
                    z2 = true;
                }
                c11174b.m9280b(z2, true);
            }
        }

        /* JADX INFO: renamed from: com.lytefast.flexinput.adapters.FileListAdapter$b$b */
        /* JADX INFO: compiled from: FileListAdapter.kt */
        public static final class b extends AbstractC12240o implements Function1<AnimatorSet, Unit> {
            public final /* synthetic */ boolean $isAnimationRequested;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(boolean z2) {
                super(1);
                this.$isAnimationRequested = z2;
            }

            /* JADX INFO: renamed from: a */
            public final void m9281a(AnimatorSet animatorSet) {
                C12238m.checkNotNullParameter(animatorSet, "animation");
                animatorSet.start();
                if (this.$isAnimationRequested) {
                    return;
                }
                animatorSet.end();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AnimatorSet animatorSet) {
                m9281a(animatorSet);
                return Unit.f27425a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11174b(FileListAdapter fileListAdapter, View view) {
            super(view);
            C12238m.checkNotNullParameter(view, "itemView");
            this.f22033h = fileListAdapter;
            View viewFindViewById = view.findViewById(C11170R.f.thumb_iv);
            C12238m.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(R.id.thumb_iv)");
            this.f22028c = (SimpleDraweeView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(C11170R.f.type_iv);
            C12238m.checkNotNullExpressionValue(viewFindViewById2, "itemView.findViewById(R.id.type_iv)");
            this.f22029d = (ImageView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(C11170R.f.file_name_tv);
            C12238m.checkNotNullExpressionValue(viewFindViewById3, "itemView.findViewById(R.id.file_name_tv)");
            this.f22030e = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(C11170R.f.file_subtitle_tv);
            C12238m.checkNotNullExpressionValue(viewFindViewById4, "itemView.findViewById(R.id.file_subtitle_tv)");
            this.f22031f = (TextView) viewFindViewById4;
            View view2 = this.itemView;
            C12238m.checkNotNullExpressionValue(view2, "this.itemView");
            view2.setClickable(true);
            this.itemView.setOnClickListener(new a());
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(view.getContext(), C11170R.a.selection_shrink);
            Objects.requireNonNull(animatorLoadAnimator, "null cannot be cast to non-null type android.animation.AnimatorSet");
            AnimatorSet animatorSet = (AnimatorSet) animatorLoadAnimator;
            this.f22026a = animatorSet;
            animatorSet.setTarget(this.f22028c);
            Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(view.getContext(), C11170R.a.selection_grow);
            Objects.requireNonNull(animatorLoadAnimator2, "null cannot be cast to non-null type android.animation.AnimatorSet");
            AnimatorSet animatorSet2 = (AnimatorSet) animatorLoadAnimator2;
            this.f22027b = animatorSet2;
            animatorSet2.setTarget(this.f22028c);
        }

        /* JADX INFO: renamed from: a */
        public final void m9279a(File file) throws IOException {
            Bitmap thumbnail;
            Cursor cursorQuery = this.f22033h.contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "mini_thumb_magic"}, "_data=?", new String[]{file.getPath()}, null);
            if (cursorQuery != null) {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        C12201b.closeFinally(cursorQuery, null);
                        return;
                    }
                    long j = cursorQuery.getLong(0);
                    if (cursorQuery.getLong(1) == 0 && (thumbnail = MediaStore.Images.Thumbnails.getThumbnail(this.f22033h.contentResolver, j, 1, null)) != null) {
                        thumbnail.recycle();
                    }
                    Cursor cursorQuery2 = this.f22033h.contentResolver.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "image_id=?", new String[]{String.valueOf(j)}, null);
                    if (cursorQuery2 != null) {
                        try {
                            if (!cursorQuery2.moveToFirst()) {
                                C12201b.closeFinally(cursorQuery2, null);
                                C12201b.closeFinally(cursorQuery, null);
                                return;
                            }
                            String string = cursorQuery2.getString(0);
                            SimpleDraweeView simpleDraweeView = this.f22028c;
                            C1733d c1733dM1037a = C1731b.m1037a();
                            c1733dM1037a.f19490n = this.f22028c.getController();
                            C1733d c1733dM1058f = c1733dM1037a.m1058f(Uri.withAppendedPath(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, string));
                            c1733dM1058f.f19488l = true;
                            simpleDraweeView.setController(c1733dM1058f.m8667a());
                            C12201b.closeFinally(cursorQuery2, null);
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                C12201b.closeFinally(cursorQuery2, th);
                                throw th2;
                            }
                        }
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            C12201b.closeFinally(cursorQuery, th);
                            throw th3;
                        }
                    }
                    C12201b.closeFinally(cursorQuery, null);
                } catch (Throwable th4) {
                    throw th4;
                }
            }
        }

        /* JADX INFO: renamed from: b */
        public final void m9280b(boolean z2, boolean z3) {
            View view = this.itemView;
            C12238m.checkNotNullExpressionValue(view, "itemView");
            view.setSelected(z2);
            b bVar = new b(z3);
            if (z2) {
                if (this.f22028c.getScaleX() == 1.0f) {
                    bVar.m9281a(this.f22026a);
                }
            } else if (this.f22028c.getScaleX() != 1.0f) {
                bVar.m9281a(this.f22027b);
            }
        }
    }

    public FileListAdapter(ContentResolver contentResolver, SelectionCoordinator<?, Attachment<File>> selectionCoordinator) {
        C12238m.checkNotNullParameter(contentResolver, "contentResolver");
        C12238m.checkNotNullParameter(selectionCoordinator, "selectionCoordinator");
        this.contentResolver = contentResolver;
        Objects.requireNonNull(selectionCoordinator);
        C12238m.checkNotNullParameter(this, "adapter");
        selectionCoordinator.adapter = this;
        this.selectionCoordinator = selectionCoordinator;
        this.files = C12147n.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.files.size();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x00e1  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws IOException {
        String mimeTypeFromExtension;
        String str;
        C11174b c11174b = (C11174b) viewHolder;
        C12238m.checkNotNullParameter(c11174b, "holder");
        Attachment<? extends File> attachment = this.files.get(i);
        Objects.requireNonNull(c11174b);
        C12238m.checkNotNullParameter(attachment, "fileAttachment");
        c11174b.f22032g = attachment;
        c11174b.m9280b(c11174b.f22033h.selectionCoordinator.m9298a(attachment, c11174b.getAdapterPosition()), false);
        File data = attachment.getData();
        if (data != null) {
            c11174b.f22030e.setText(data.getName());
            TextView textView = c11174b.f22031f;
            C12238m.checkNotNullParameter(data, "$this$getFileSize");
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
            c11174b.f22030e.setText((CharSequence) null);
            c11174b.f22031f.setText((CharSequence) null);
        }
        SimpleDraweeView simpleDraweeView = c11174b.f22028c;
        simpleDraweeView.setImageURI((Uri) null, simpleDraweeView.getContext());
        c11174b.f22029d.setVisibility(8);
        boolean z2 = true;
        if (data != null) {
            Objects.requireNonNull(c11174b.f22033h);
            String name = data.getName();
            C12238m.checkNotNullExpressionValue(name, "fileName");
            int iLastIndexOf$default = C12106w.lastIndexOf$default((CharSequence) name, '.', 0, false, 6, (Object) null) + 1;
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = name.substring(iLastIndexOf$default);
            C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
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
        c11174b.f22028c.setImageURI(Uri.fromFile(data), c11174b.f22028c.getContext());
        if (C12103t.startsWith$default(mimeTypeFromExtension, "image", false, 2, null)) {
            ImageView imageView = c11174b.f22029d;
            imageView.setImageResource(DrawableCompat.getThemedDrawableRes$default(imageView, C11170R.b.ic_flex_input_image, 0, 2, (Object) null));
            c11174b.f22029d.setVisibility(0);
            c11174b.m9279a(data);
            return;
        }
        if (C12103t.startsWith$default(mimeTypeFromExtension, MediaStreamTrack.VIDEO_TRACK_KIND, false, 2, null)) {
            ImageView imageView2 = c11174b.f22029d;
            imageView2.setImageResource(DrawableCompat.getThemedDrawableRes$default(imageView2, C11170R.b.ic_flex_input_movie, 0, 2, (Object) null));
            c11174b.f22029d.setVisibility(0);
            c11174b.m9279a(data);
            return;
        }
        if (C12103t.startsWith$default(mimeTypeFromExtension, MediaStreamTrack.AUDIO_TRACK_KIND, false, 2, null)) {
            ImageView imageView3 = c11174b.f22029d;
            imageView3.setImageResource(DrawableCompat.getThemedDrawableRes$default(imageView3, C11170R.b.ic_flex_input_audio, 0, 2, (Object) null));
            c11174b.f22029d.setVisibility(0);
            c11174b.m9279a(data);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        C12238m.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(C11170R.g.view_file_item, viewGroup, false);
        C12238m.checkNotNullExpressionValue(viewInflate, "view");
        return new C11174b(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        Object next;
        C11174b c11174b = (C11174b) viewHolder;
        C12238m.checkNotNullParameter(c11174b, "holder");
        C12238m.checkNotNullParameter(list, "payloads");
        Iterator it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(next instanceof SelectionCoordinator.C11192a));
        if (next != null) {
            SelectionCoordinator.C11192a c11192a = (SelectionCoordinator.C11192a) (next instanceof SelectionCoordinator.C11192a ? next : null);
            if (c11192a != null) {
                c11174b.m9280b(c11192a.f22090b, true);
                return;
            }
        }
        super.onBindViewHolder(c11174b, i, list);
    }
}
