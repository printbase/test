package com.example.demo;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Date;
import org.apache.sshd.common.cipher.BuiltinCiphers;
import org.apache.sshd.common.forward.PortForwardingEventListener;
import org.apache.sshd.common.keyprovider.FileKeyPairProvider;
import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.auth.AsyncAuthException;
import org.apache.sshd.server.auth.password.PasswordAuthenticator;
import org.apache.sshd.server.auth.password.PasswordChangeRequiredException;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
import org.apache.sshd.server.session.ServerSession;
import org.apache.sshd.server.shell.ProcessShellFactory;

public class Test {
	public static void main(String[] args) throws Exception {
		SshServer ss = SshServer.setUpDefaultServer();
		String file = "id";
			ss.setKeyPairProvider(new SimpleGeneratorHostKeyProvider(Path.of(file)));
			System.setProperty("java.net.useSystemProxies", "true");

		ss.setCipherFactories(
				Arrays.asList(BuiltinCiphers.aes256ctr, BuiltinCiphers.aes192ctr, BuiltinCiphers.aes128ctr));
		ss.setShellFactory(new ProcessShellFactory("C:\\Program Files\\Git\\bin\\sh.exe", "-i","-l","-r","-s","-L"));
		String p = "121212";//(int) (Math.random() * 1000000) + "";
		System.out.println(p);
		ss.setPort(8080);

		ss.setPasswordAuthenticator(new PasswordAuthenticator() {

			@Override
			public boolean authenticate(String u, String p1, ServerSession session)
					throws PasswordChangeRequiredException, AsyncAuthException {
				System.out.println(new Date() + "/" + p);

				return p.equals(p1);
			}
		});

		ss.start();
		while (true)
			Thread.sleep(1000);

	}
}
