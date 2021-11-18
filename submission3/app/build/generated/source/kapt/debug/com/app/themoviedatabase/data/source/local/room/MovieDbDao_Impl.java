package com.app.themoviedatabase.data.source.local.room;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.paging.LimitOffsetDataSource;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.app.themoviedatabase.data.source.local.entity.MovieEntity;
import com.app.themoviedatabase.data.source.local.entity.TvShowEntity;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MovieDbDao_Impl implements MovieDbDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MovieEntity> __insertionAdapterOfMovieEntity;

  private final EntityInsertionAdapter<TvShowEntity> __insertionAdapterOfTvShowEntity;

  private final EntityDeletionOrUpdateAdapter<MovieEntity> __updateAdapterOfMovieEntity;

  private final EntityDeletionOrUpdateAdapter<TvShowEntity> __updateAdapterOfTvShowEntity;

  public MovieDbDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMovieEntity = new EntityInsertionAdapter<MovieEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `movieentities` (`movieId`,`title`,`releaseDate`,`overview`,`language`,`score`,`popularity`,`imagePath`,`backdropPath`,`favourited`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MovieEntity value) {
        stmt.bindLong(1, value.getMovieId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getReleaseDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getReleaseDate());
        }
        if (value.getOverview() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOverview());
        }
        if (value.getLanguage() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLanguage());
        }
        stmt.bindDouble(6, value.getScore());
        stmt.bindDouble(7, value.getPopularity());
        if (value.getImagePath() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getImagePath());
        }
        if (value.getBackdropPath() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getBackdropPath());
        }
        final int _tmp;
        _tmp = value.getFavourited() ? 1 : 0;
        stmt.bindLong(10, _tmp);
      }
    };
    this.__insertionAdapterOfTvShowEntity = new EntityInsertionAdapter<TvShowEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `tvshowentities` (`tvShowId`,`title`,`releaseDate`,`overview`,`language`,`score`,`popularity`,`imagePath`,`backdropPath`,`favourited`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TvShowEntity value) {
        stmt.bindLong(1, value.getTvShowId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getReleaseDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getReleaseDate());
        }
        if (value.getOverview() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOverview());
        }
        if (value.getLanguage() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLanguage());
        }
        stmt.bindDouble(6, value.getScore());
        stmt.bindDouble(7, value.getPopularity());
        if (value.getImagePath() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getImagePath());
        }
        if (value.getBackdropPath() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getBackdropPath());
        }
        final int _tmp;
        _tmp = value.getFavourited() ? 1 : 0;
        stmt.bindLong(10, _tmp);
      }
    };
    this.__updateAdapterOfMovieEntity = new EntityDeletionOrUpdateAdapter<MovieEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `movieentities` SET `movieId` = ?,`title` = ?,`releaseDate` = ?,`overview` = ?,`language` = ?,`score` = ?,`popularity` = ?,`imagePath` = ?,`backdropPath` = ?,`favourited` = ? WHERE `movieId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MovieEntity value) {
        stmt.bindLong(1, value.getMovieId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getReleaseDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getReleaseDate());
        }
        if (value.getOverview() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOverview());
        }
        if (value.getLanguage() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLanguage());
        }
        stmt.bindDouble(6, value.getScore());
        stmt.bindDouble(7, value.getPopularity());
        if (value.getImagePath() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getImagePath());
        }
        if (value.getBackdropPath() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getBackdropPath());
        }
        final int _tmp;
        _tmp = value.getFavourited() ? 1 : 0;
        stmt.bindLong(10, _tmp);
        stmt.bindLong(11, value.getMovieId());
      }
    };
    this.__updateAdapterOfTvShowEntity = new EntityDeletionOrUpdateAdapter<TvShowEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `tvshowentities` SET `tvShowId` = ?,`title` = ?,`releaseDate` = ?,`overview` = ?,`language` = ?,`score` = ?,`popularity` = ?,`imagePath` = ?,`backdropPath` = ?,`favourited` = ? WHERE `tvShowId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TvShowEntity value) {
        stmt.bindLong(1, value.getTvShowId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getReleaseDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getReleaseDate());
        }
        if (value.getOverview() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOverview());
        }
        if (value.getLanguage() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLanguage());
        }
        stmt.bindDouble(6, value.getScore());
        stmt.bindDouble(7, value.getPopularity());
        if (value.getImagePath() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getImagePath());
        }
        if (value.getBackdropPath() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getBackdropPath());
        }
        final int _tmp;
        _tmp = value.getFavourited() ? 1 : 0;
        stmt.bindLong(10, _tmp);
        stmt.bindLong(11, value.getTvShowId());
      }
    };
  }

  @Override
  public void insertMovies(final List<MovieEntity> movies) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMovieEntity.insert(movies);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertTvShow(final List<TvShowEntity> tvShows) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTvShowEntity.insert(tvShows);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateMovies(final MovieEntity movies) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfMovieEntity.handle(movies);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateTvShows(final TvShowEntity tvShows) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTvShowEntity.handle(tvShows);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public DataSource.Factory<Integer, MovieEntity> getMovies() {
    final String _sql = "SELECT * FROM movieentities";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new DataSource.Factory<Integer, MovieEntity>() {
      @Override
      public LimitOffsetDataSource<MovieEntity> create() {
        return new LimitOffsetDataSource<MovieEntity>(__db, _statement, false , "movieentities") {
          @Override
          protected List<MovieEntity> convertRows(Cursor cursor) {
            final int _cursorIndexOfMovieId = CursorUtil.getColumnIndexOrThrow(cursor, "movieId");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(cursor, "releaseDate");
            final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(cursor, "overview");
            final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(cursor, "language");
            final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(cursor, "score");
            final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(cursor, "popularity");
            final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(cursor, "imagePath");
            final int _cursorIndexOfBackdropPath = CursorUtil.getColumnIndexOrThrow(cursor, "backdropPath");
            final int _cursorIndexOfFavourited = CursorUtil.getColumnIndexOrThrow(cursor, "favourited");
            final List<MovieEntity> _res = new ArrayList<MovieEntity>(cursor.getCount());
            while(cursor.moveToNext()) {
              final MovieEntity _item;
              final int _tmpMovieId;
              _tmpMovieId = cursor.getInt(_cursorIndexOfMovieId);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              final String _tmpReleaseDate;
              _tmpReleaseDate = cursor.getString(_cursorIndexOfReleaseDate);
              final String _tmpOverview;
              _tmpOverview = cursor.getString(_cursorIndexOfOverview);
              final String _tmpLanguage;
              _tmpLanguage = cursor.getString(_cursorIndexOfLanguage);
              final double _tmpScore;
              _tmpScore = cursor.getDouble(_cursorIndexOfScore);
              final double _tmpPopularity;
              _tmpPopularity = cursor.getDouble(_cursorIndexOfPopularity);
              final String _tmpImagePath;
              _tmpImagePath = cursor.getString(_cursorIndexOfImagePath);
              final String _tmpBackdropPath;
              _tmpBackdropPath = cursor.getString(_cursorIndexOfBackdropPath);
              final boolean _tmpFavourited;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfFavourited);
              _tmpFavourited = _tmp != 0;
              _item = new MovieEntity(_tmpMovieId,_tmpTitle,_tmpReleaseDate,_tmpOverview,_tmpLanguage,_tmpScore,_tmpPopularity,_tmpImagePath,_tmpBackdropPath,_tmpFavourited);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, MovieEntity> getFavouritedMovie() {
    final String _sql = "SELECT * FROM movieentities WHERE favourited = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new DataSource.Factory<Integer, MovieEntity>() {
      @Override
      public LimitOffsetDataSource<MovieEntity> create() {
        return new LimitOffsetDataSource<MovieEntity>(__db, _statement, false , "movieentities") {
          @Override
          protected List<MovieEntity> convertRows(Cursor cursor) {
            final int _cursorIndexOfMovieId = CursorUtil.getColumnIndexOrThrow(cursor, "movieId");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(cursor, "releaseDate");
            final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(cursor, "overview");
            final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(cursor, "language");
            final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(cursor, "score");
            final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(cursor, "popularity");
            final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(cursor, "imagePath");
            final int _cursorIndexOfBackdropPath = CursorUtil.getColumnIndexOrThrow(cursor, "backdropPath");
            final int _cursorIndexOfFavourited = CursorUtil.getColumnIndexOrThrow(cursor, "favourited");
            final List<MovieEntity> _res = new ArrayList<MovieEntity>(cursor.getCount());
            while(cursor.moveToNext()) {
              final MovieEntity _item;
              final int _tmpMovieId;
              _tmpMovieId = cursor.getInt(_cursorIndexOfMovieId);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              final String _tmpReleaseDate;
              _tmpReleaseDate = cursor.getString(_cursorIndexOfReleaseDate);
              final String _tmpOverview;
              _tmpOverview = cursor.getString(_cursorIndexOfOverview);
              final String _tmpLanguage;
              _tmpLanguage = cursor.getString(_cursorIndexOfLanguage);
              final double _tmpScore;
              _tmpScore = cursor.getDouble(_cursorIndexOfScore);
              final double _tmpPopularity;
              _tmpPopularity = cursor.getDouble(_cursorIndexOfPopularity);
              final String _tmpImagePath;
              _tmpImagePath = cursor.getString(_cursorIndexOfImagePath);
              final String _tmpBackdropPath;
              _tmpBackdropPath = cursor.getString(_cursorIndexOfBackdropPath);
              final boolean _tmpFavourited;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfFavourited);
              _tmpFavourited = _tmp != 0;
              _item = new MovieEntity(_tmpMovieId,_tmpTitle,_tmpReleaseDate,_tmpOverview,_tmpLanguage,_tmpScore,_tmpPopularity,_tmpImagePath,_tmpBackdropPath,_tmpFavourited);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public LiveData<MovieEntity> getMovieById(final int movieId) {
    final String _sql = "SELECT * FROM movieentities WHERE movieId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, movieId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"movieentities"}, false, new Callable<MovieEntity>() {
      @Override
      public MovieEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMovieId = CursorUtil.getColumnIndexOrThrow(_cursor, "movieId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "releaseDate");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(_cursor, "score");
          final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "popularity");
          final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "imagePath");
          final int _cursorIndexOfBackdropPath = CursorUtil.getColumnIndexOrThrow(_cursor, "backdropPath");
          final int _cursorIndexOfFavourited = CursorUtil.getColumnIndexOrThrow(_cursor, "favourited");
          final MovieEntity _result;
          if(_cursor.moveToFirst()) {
            final int _tmpMovieId;
            _tmpMovieId = _cursor.getInt(_cursorIndexOfMovieId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpReleaseDate;
            _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            final String _tmpOverview;
            _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            final String _tmpLanguage;
            _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            final double _tmpScore;
            _tmpScore = _cursor.getDouble(_cursorIndexOfScore);
            final double _tmpPopularity;
            _tmpPopularity = _cursor.getDouble(_cursorIndexOfPopularity);
            final String _tmpImagePath;
            _tmpImagePath = _cursor.getString(_cursorIndexOfImagePath);
            final String _tmpBackdropPath;
            _tmpBackdropPath = _cursor.getString(_cursorIndexOfBackdropPath);
            final boolean _tmpFavourited;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfFavourited);
            _tmpFavourited = _tmp != 0;
            _result = new MovieEntity(_tmpMovieId,_tmpTitle,_tmpReleaseDate,_tmpOverview,_tmpLanguage,_tmpScore,_tmpPopularity,_tmpImagePath,_tmpBackdropPath,_tmpFavourited);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public DataSource.Factory<Integer, TvShowEntity> getTvShows() {
    final String _sql = "SELECT * FROM tvshowentities";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new DataSource.Factory<Integer, TvShowEntity>() {
      @Override
      public LimitOffsetDataSource<TvShowEntity> create() {
        return new LimitOffsetDataSource<TvShowEntity>(__db, _statement, false , "tvshowentities") {
          @Override
          protected List<TvShowEntity> convertRows(Cursor cursor) {
            final int _cursorIndexOfTvShowId = CursorUtil.getColumnIndexOrThrow(cursor, "tvShowId");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(cursor, "releaseDate");
            final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(cursor, "overview");
            final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(cursor, "language");
            final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(cursor, "score");
            final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(cursor, "popularity");
            final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(cursor, "imagePath");
            final int _cursorIndexOfBackdropPath = CursorUtil.getColumnIndexOrThrow(cursor, "backdropPath");
            final int _cursorIndexOfFavourited = CursorUtil.getColumnIndexOrThrow(cursor, "favourited");
            final List<TvShowEntity> _res = new ArrayList<TvShowEntity>(cursor.getCount());
            while(cursor.moveToNext()) {
              final TvShowEntity _item;
              final int _tmpTvShowId;
              _tmpTvShowId = cursor.getInt(_cursorIndexOfTvShowId);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              final String _tmpReleaseDate;
              _tmpReleaseDate = cursor.getString(_cursorIndexOfReleaseDate);
              final String _tmpOverview;
              _tmpOverview = cursor.getString(_cursorIndexOfOverview);
              final String _tmpLanguage;
              _tmpLanguage = cursor.getString(_cursorIndexOfLanguage);
              final double _tmpScore;
              _tmpScore = cursor.getDouble(_cursorIndexOfScore);
              final double _tmpPopularity;
              _tmpPopularity = cursor.getDouble(_cursorIndexOfPopularity);
              final String _tmpImagePath;
              _tmpImagePath = cursor.getString(_cursorIndexOfImagePath);
              final String _tmpBackdropPath;
              _tmpBackdropPath = cursor.getString(_cursorIndexOfBackdropPath);
              final boolean _tmpFavourited;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfFavourited);
              _tmpFavourited = _tmp != 0;
              _item = new TvShowEntity(_tmpTvShowId,_tmpTitle,_tmpReleaseDate,_tmpOverview,_tmpLanguage,_tmpScore,_tmpPopularity,_tmpImagePath,_tmpBackdropPath,_tmpFavourited);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, TvShowEntity> getFavouritedTvShows() {
    final String _sql = "SELECT * FROM tvshowentities WHERE favourited = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new DataSource.Factory<Integer, TvShowEntity>() {
      @Override
      public LimitOffsetDataSource<TvShowEntity> create() {
        return new LimitOffsetDataSource<TvShowEntity>(__db, _statement, false , "tvshowentities") {
          @Override
          protected List<TvShowEntity> convertRows(Cursor cursor) {
            final int _cursorIndexOfTvShowId = CursorUtil.getColumnIndexOrThrow(cursor, "tvShowId");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(cursor, "releaseDate");
            final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(cursor, "overview");
            final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(cursor, "language");
            final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(cursor, "score");
            final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(cursor, "popularity");
            final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(cursor, "imagePath");
            final int _cursorIndexOfBackdropPath = CursorUtil.getColumnIndexOrThrow(cursor, "backdropPath");
            final int _cursorIndexOfFavourited = CursorUtil.getColumnIndexOrThrow(cursor, "favourited");
            final List<TvShowEntity> _res = new ArrayList<TvShowEntity>(cursor.getCount());
            while(cursor.moveToNext()) {
              final TvShowEntity _item;
              final int _tmpTvShowId;
              _tmpTvShowId = cursor.getInt(_cursorIndexOfTvShowId);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              final String _tmpReleaseDate;
              _tmpReleaseDate = cursor.getString(_cursorIndexOfReleaseDate);
              final String _tmpOverview;
              _tmpOverview = cursor.getString(_cursorIndexOfOverview);
              final String _tmpLanguage;
              _tmpLanguage = cursor.getString(_cursorIndexOfLanguage);
              final double _tmpScore;
              _tmpScore = cursor.getDouble(_cursorIndexOfScore);
              final double _tmpPopularity;
              _tmpPopularity = cursor.getDouble(_cursorIndexOfPopularity);
              final String _tmpImagePath;
              _tmpImagePath = cursor.getString(_cursorIndexOfImagePath);
              final String _tmpBackdropPath;
              _tmpBackdropPath = cursor.getString(_cursorIndexOfBackdropPath);
              final boolean _tmpFavourited;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfFavourited);
              _tmpFavourited = _tmp != 0;
              _item = new TvShowEntity(_tmpTvShowId,_tmpTitle,_tmpReleaseDate,_tmpOverview,_tmpLanguage,_tmpScore,_tmpPopularity,_tmpImagePath,_tmpBackdropPath,_tmpFavourited);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public LiveData<TvShowEntity> getTvShowById(final int tvShowId) {
    final String _sql = "SELECT * FROM tvshowentities WHERE tvShowId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, tvShowId);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tvshowentities"}, false, new Callable<TvShowEntity>() {
      @Override
      public TvShowEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTvShowId = CursorUtil.getColumnIndexOrThrow(_cursor, "tvShowId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "releaseDate");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "language");
          final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(_cursor, "score");
          final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "popularity");
          final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "imagePath");
          final int _cursorIndexOfBackdropPath = CursorUtil.getColumnIndexOrThrow(_cursor, "backdropPath");
          final int _cursorIndexOfFavourited = CursorUtil.getColumnIndexOrThrow(_cursor, "favourited");
          final TvShowEntity _result;
          if(_cursor.moveToFirst()) {
            final int _tmpTvShowId;
            _tmpTvShowId = _cursor.getInt(_cursorIndexOfTvShowId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpReleaseDate;
            _tmpReleaseDate = _cursor.getString(_cursorIndexOfReleaseDate);
            final String _tmpOverview;
            _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
            final String _tmpLanguage;
            _tmpLanguage = _cursor.getString(_cursorIndexOfLanguage);
            final double _tmpScore;
            _tmpScore = _cursor.getDouble(_cursorIndexOfScore);
            final double _tmpPopularity;
            _tmpPopularity = _cursor.getDouble(_cursorIndexOfPopularity);
            final String _tmpImagePath;
            _tmpImagePath = _cursor.getString(_cursorIndexOfImagePath);
            final String _tmpBackdropPath;
            _tmpBackdropPath = _cursor.getString(_cursorIndexOfBackdropPath);
            final boolean _tmpFavourited;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfFavourited);
            _tmpFavourited = _tmp != 0;
            _result = new TvShowEntity(_tmpTvShowId,_tmpTitle,_tmpReleaseDate,_tmpOverview,_tmpLanguage,_tmpScore,_tmpPopularity,_tmpImagePath,_tmpBackdropPath,_tmpFavourited);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
