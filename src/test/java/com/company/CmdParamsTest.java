package com.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.company.TestData.RIGHT_FULL_ARGS;
import static org.junit.jupiter.api.Assertions.*;

class CmdParamsTest {

		@Test
		@DisplayName("Корректность заполнения параметров")
		void fillParams() {
				CmdParams cmdParams = CmdParams.getInstance();
				cmdParams.fillParams(RIGHT_FULL_ARGS);
				assertNotNull(cmdParams.getFileForReading());
				assertNotNull(cmdParams.getFileNameForWriting());
				assertNotNull(cmdParams.getDataType());
				assertNotNull(cmdParams.getOrderType());
		}
}