package jooq.util.connection;

import java.sql.Connection;
import java.sql.SQLException;

import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;

public class DSLConnection extends DefaultDSLContext implements AutoCloseable {
	private static final long serialVersionUID = 1L;
	private final Connection con;
	public final SQLDialect dialect;
	
	public DSLConnection(Connection con, SQLDialect dialect) {
		super(con, dialect);
		this.dialect = dialect;
		this.con = con;
	}

	@Override
	public void close() throws SQLException {
		if (this.con != null) {
			this.con.close();
		}
	}
}
