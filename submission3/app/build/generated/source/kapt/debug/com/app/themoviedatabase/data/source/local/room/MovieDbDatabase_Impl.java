package com.app.themoviedatabase.data.source.local.room;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MovieDbDatabase_Impl extends MovieDbDatabase {
  private volatile MovieDbDao _movieDbDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `movieentities` (`movieId` INTEGER NOT NULL, `title` TEXT NOT NULL, `releaseDate` TEXT NOT NULL, `overview` TEXT NOT NULL, `language` TEXT NOT NULL, `score` REAL NOT NULL, `popularity` REAL NOT NULL, `imagePath` TEXT, `backdropPath` TEXT, `favourited` INTEGER NOT NULL, PRIMARY KEY(`movieId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tvshowentities` (`tvShowId` INTEGER NOT NULL, `title` TEXT NOT NULL, `releaseDate` TEXT NOT NULL, `overview` TEXT NOT NULL, `language` TEXT NOT NULL, `score` REAL NOT NULL, `popularity` REAL NOT NULL, `imagePath` TEXT, `backdropPath` TEXT, `favourited` INTEGER NOT NULL, PRIMARY KEY(`tvShowId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9560d03fdbdbe9c15b793b59873aff52')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `movieentities`");
        _db.execSQL("DROP TABLE IF EXISTS `tvshowentities`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsMovieentities = new HashMap<String, TableInfo.Column>(10);
        _columnsMovieentities.put("movieId", new TableInfo.Column("movieId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieentities.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieentities.put("releaseDate", new TableInfo.Column("releaseDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieentities.put("overview", new TableInfo.Column("overview", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieentities.put("language", new TableInfo.Column("language", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieentities.put("score", new TableInfo.Column("score", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieentities.put("popularity", new TableInfo.Column("popularity", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieentities.put("imagePath", new TableInfo.Column("imagePath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieentities.put("backdropPath", new TableInfo.Column("backdropPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMovieentities.put("favourited", new TableInfo.Column("favourited", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMovieentities = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMovieentities = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMovieentities = new TableInfo("movieentities", _columnsMovieentities, _foreignKeysMovieentities, _indicesMovieentities);
        final TableInfo _existingMovieentities = TableInfo.read(_db, "movieentities");
        if (! _infoMovieentities.equals(_existingMovieentities)) {
          return new RoomOpenHelper.ValidationResult(false, "movieentities(com.app.themoviedatabase.data.source.local.entity.MovieEntity).\n"
                  + " Expected:\n" + _infoMovieentities + "\n"
                  + " Found:\n" + _existingMovieentities);
        }
        final HashMap<String, TableInfo.Column> _columnsTvshowentities = new HashMap<String, TableInfo.Column>(10);
        _columnsTvshowentities.put("tvShowId", new TableInfo.Column("tvShowId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTvshowentities.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTvshowentities.put("releaseDate", new TableInfo.Column("releaseDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTvshowentities.put("overview", new TableInfo.Column("overview", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTvshowentities.put("language", new TableInfo.Column("language", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTvshowentities.put("score", new TableInfo.Column("score", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTvshowentities.put("popularity", new TableInfo.Column("popularity", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTvshowentities.put("imagePath", new TableInfo.Column("imagePath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTvshowentities.put("backdropPath", new TableInfo.Column("backdropPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTvshowentities.put("favourited", new TableInfo.Column("favourited", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTvshowentities = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTvshowentities = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTvshowentities = new TableInfo("tvshowentities", _columnsTvshowentities, _foreignKeysTvshowentities, _indicesTvshowentities);
        final TableInfo _existingTvshowentities = TableInfo.read(_db, "tvshowentities");
        if (! _infoTvshowentities.equals(_existingTvshowentities)) {
          return new RoomOpenHelper.ValidationResult(false, "tvshowentities(com.app.themoviedatabase.data.source.local.entity.TvShowEntity).\n"
                  + " Expected:\n" + _infoTvshowentities + "\n"
                  + " Found:\n" + _existingTvshowentities);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "9560d03fdbdbe9c15b793b59873aff52", "36ebb55aed75c4d74bb83aa233d4a17d");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "movieentities","tvshowentities");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `movieentities`");
      _db.execSQL("DELETE FROM `tvshowentities`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public MovieDbDao movieDbDao() {
    if (_movieDbDao != null) {
      return _movieDbDao;
    } else {
      synchronized(this) {
        if(_movieDbDao == null) {
          _movieDbDao = new MovieDbDao_Impl(this);
        }
        return _movieDbDao;
      }
    }
  }
}
