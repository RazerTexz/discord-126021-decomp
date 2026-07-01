package com.lytefast.flexinput.adapters;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore$Images$Media;
import android.provider.MediaStore$Images$Thumbnails;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.f.g.a.a.d;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lytefast.flexinput.R$a;
import com.lytefast.flexinput.R$f;
import com.lytefast.flexinput.model.Attachment;
import d0.y.b;
import d0.z.d.m;
import java.io.File;
import java.util.Objects;

/* JADX INFO: compiled from: FileListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public class FileListAdapter$b extends RecyclerView$ViewHolder {
    public final AnimatorSet a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnimatorSet f3162b;
    public SimpleDraweeView c;
    public ImageView d;
    public TextView e;
    public TextView f;
    public Attachment<? extends File> g;
    public final /* synthetic */ FileListAdapter h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileListAdapter$b(FileListAdapter fileListAdapter, View view) {
        super(view);
        m.checkNotNullParameter(view, "itemView");
        this.h = fileListAdapter;
        View viewFindViewById = view.findViewById(R$f.thumb_iv);
        m.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(R.id.thumb_iv)");
        this.c = (SimpleDraweeView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R$f.type_iv);
        m.checkNotNullExpressionValue(viewFindViewById2, "itemView.findViewById(R.id.type_iv)");
        this.d = (ImageView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R$f.file_name_tv);
        m.checkNotNullExpressionValue(viewFindViewById3, "itemView.findViewById(R.id.file_name_tv)");
        this.e = (TextView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R$f.file_subtitle_tv);
        m.checkNotNullExpressionValue(viewFindViewById4, "itemView.findViewById(R.id.file_subtitle_tv)");
        this.f = (TextView) viewFindViewById4;
        View view2 = this.itemView;
        m.checkNotNullExpressionValue(view2, "this.itemView");
        view2.setClickable(true);
        this.itemView.setOnClickListener(new FileListAdapter$b$a(this));
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(view.getContext(), R$a.selection_shrink);
        Objects.requireNonNull(animatorLoadAnimator, "null cannot be cast to non-null type android.animation.AnimatorSet");
        AnimatorSet animatorSet = (AnimatorSet) animatorLoadAnimator;
        this.a = animatorSet;
        animatorSet.setTarget(this.c);
        Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(view.getContext(), R$a.selection_grow);
        Objects.requireNonNull(animatorLoadAnimator2, "null cannot be cast to non-null type android.animation.AnimatorSet");
        AnimatorSet animatorSet2 = (AnimatorSet) animatorLoadAnimator2;
        this.f3162b = animatorSet2;
        animatorSet2.setTarget(this.c);
    }

    public final void a(File file) {
        Bitmap thumbnail;
        Cursor cursorQuery = this.h.contentResolver.query(MediaStore$Images$Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "mini_thumb_magic"}, "_data=?", new String[]{file.getPath()}, null);
        if (cursorQuery != null) {
            try {
                if (!cursorQuery.moveToFirst()) {
                    b.closeFinally(cursorQuery, null);
                    return;
                }
                long j = cursorQuery.getLong(0);
                if (cursorQuery.getLong(1) == 0 && (thumbnail = MediaStore$Images$Thumbnails.getThumbnail(this.h.contentResolver, j, 1, null)) != null) {
                    thumbnail.recycle();
                }
                Cursor cursorQuery2 = this.h.contentResolver.query(MediaStore$Images$Thumbnails.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "image_id=?", new String[]{String.valueOf(j)}, null);
                if (cursorQuery2 != null) {
                    try {
                        if (!cursorQuery2.moveToFirst()) {
                            b.closeFinally(cursorQuery2, null);
                            b.closeFinally(cursorQuery, null);
                            return;
                        }
                        String string = cursorQuery2.getString(0);
                        SimpleDraweeView simpleDraweeView = this.c;
                        d dVarA = b.f.g.a.a.b.a();
                        dVarA.n = this.c.getController();
                        d dVarF = dVarA.f(Uri.withAppendedPath(MediaStore$Images$Thumbnails.EXTERNAL_CONTENT_URI, string));
                        dVarF.l = true;
                        simpleDraweeView.setController(dVarF.a());
                        b.closeFinally(cursorQuery2, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            b.closeFinally(cursorQuery2, th);
                            throw th2;
                        }
                    }
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        b.closeFinally(cursorQuery, th);
                        throw th3;
                    }
                }
                b.closeFinally(cursorQuery, null);
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    public final void b(boolean z2, boolean z3) {
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        view.setSelected(z2);
        FileListAdapter$b$b fileListAdapter$b$b = new FileListAdapter$b$b(z3);
        if (z2) {
            if (this.c.getScaleX() == 1.0f) {
                fileListAdapter$b$b.a(this.a);
            }
        } else if (this.c.getScaleX() != 1.0f) {
            fileListAdapter$b$b.a(this.f3162b);
        }
    }
}
