INSERT INTO trade_signals(SIGNAL, TYPE, CALCULATE) VALUES (1, 'SETUP', true);
INSERT INTO trade_signals(SIGNAL, TYPE, CALCULATE) VALUES (2, 'REVERSE', false);
INSERT INTO trade_signals(SIGNAL, TYPE, CALCULATE) VALUES (3, 'NONE', true);
INSERT INTO trade_signals(SIGNAL, TYPE, CALCULATE) VALUES (4, 'REVERSE', true);
INSERT INTO signal_specifications(SIGNAL_ID, PARAM_NR, PARAM_VALUE) VALUES (1, 1, 60);
INSERT INTO signal_specifications(SIGNAL_ID, PARAM_NR, PARAM_VALUE) VALUES (2, 1, 80);
INSERT INTO signal_specifications(SIGNAL_ID, PARAM_NR, PARAM_VALUE) VALUES (3, 1, 90);
INSERT INTO signal_specifications(SIGNAL_ID, PARAM_NR, PARAM_VALUE) VALUES (3, 2, 15);
INSERT INTO signal_specifications(SIGNAL_ID, PARAM_NR, PARAM_VALUE) VALUES (4, 1, 45);
INSERT INTO signal_specifications(SIGNAL_ID, PARAM_NR, PARAM_VALUE) VALUES (4, 2, 75);